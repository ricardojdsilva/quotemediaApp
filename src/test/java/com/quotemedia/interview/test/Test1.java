package com.quotemedia.interview.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quotemedia.interview.repositories.QuoteRepository;
import com.quotemedia.interview.services.QuoteService;

class Test1 {

	
	@Autowired
	QuoteService quoteservice = new QuoteService();
	
	@Autowired
	QuoteRepository quoterep;
	
	@Test
	void testFindAll() {
		

		
		assertEquals(15, quoteservice.findAll());
		
	}

}
