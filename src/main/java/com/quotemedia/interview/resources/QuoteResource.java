package com.quotemedia.interview.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quotemedia.interview.entities.Quote;
import com.quotemedia.interview.services.QuoteService;

@RestController
@RequestMapping(value="/symbols")
public class QuoteResource {
	
	
	@Autowired
	private QuoteService service;
	
	//this method retrieve all information from table QUOTES
	@GetMapping
	public ResponseEntity<List<Quote>> findAll(){
		
		
		List<Quote> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	
	//this method retrieve information by Symbol name EX: MSF, GOOG AND FB
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<Quote>> findById(@PathVariable("id") String symbol){
		
		
		List<Quote> list = service.findBySymbol(symbol.toUpperCase());
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//this method retrieve information by Symbol name EX: MSF, GOOG AND FB
	@GetMapping(value = "/{id}/quotes")
	public ResponseEntity<List<Quote>> findByQuotes(@PathVariable("id") String symbol){
		
		
		List<Quote> list = service.findBySymbol(symbol);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//this method retrieve the latest quote  by Symbol name EX: MSF, GOOG AND FB
	@GetMapping(value = "/{id}/quotes/latest")
	public ResponseEntity<List<Quote>> findLastQuoteBySymbol(@PathVariable("id") String symbol){
		
		List<Quote> list = null;
		if (ValidateSymbol(symbol)) {
			 list = service.findLastest(symbol.toUpperCase());
			 //RETURN 404 Not found
			 if (list.size() == 0) throw new ResourceNotFoundException();				
			 
		}else {
			
			// RETURN 400 BAD REQUEST
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		return ResponseEntity.ok().body(list);
		
	}
	
	
	//This method retrieve the highest ask for a given day.
	@GetMapping(value = "/{date}/highest/ask")
	public ResponseEntity<List<Quote>> findHighestByDate(@PathVariable("date") String date){
		List<Quote> list = null;
		
		list = service.findHighest(date);
		if (list.size() == 0) throw new ResourceNotFoundException();		
		
		return ResponseEntity.ok().body(list);
	}
	
	//This method check if there symbol exist and also valid the length of symbol 2 to 6
	public boolean ValidateSymbol(String symbol) {
		
		
		if (symbol.length() < 2 || symbol.length() > 6) {
			return false;
		}else {
			return true;
		}
			
	}
	
	
	
	
}
