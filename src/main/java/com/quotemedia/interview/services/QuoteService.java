package com.quotemedia.interview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quotemedia.interview.entities.Quote;
import com.quotemedia.interview.repositories.QuoteRepository;
import com.quotemedia.interview.services.exceptions.ResourceNotFoundException;

@Service
public class QuoteService {
	
	@Autowired
	private QuoteRepository repository;
	
	//this method implement the Interface to JPA and retrieve all information from table QUOTES
	public List<Quote> findAll(){
		return repository.findAll();
	}
	
	//this method implement the Interface to JPA and  retrieve information by Symbol name EX: MSF, GOOG AND FB
	public List<Quote> findBySymbol(String symbol){
		
		return repository.findBySymbolEquals(symbol);
		
	}
	
	public Quote findLastestBySymbol(String symbol){
		
	
		Optional<Quote> obj = Optional.of(repository.findLatestQuoteBySymbol(symbol));
		
		return obj.orElseThrow(() -> new ResourceNotFoundException(symbol));
		
	}
	
	
	public List<Quote> findLastest(String symbol){
		
		return repository.findQuoteBySymbol(symbol);
		
	}
	
	//retrieve the symbol with the highest ask for a given day.
	public List<Quote> findHighest(String date){
		
		return repository.findMaxAskByDate(date);
		
	}
	
}

