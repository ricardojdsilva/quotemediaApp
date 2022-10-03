package com.quotemedia.interview.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quotemedia.interview.entities.Quote;


public interface QuoteRepository extends JpaRepository<Quote, String> {

	List<Quote> findBySymbolEquals(String symbol);
	
	
	@Query(value ="select symbol, day, BID, ASK from Quote where SYMBOL = ?1 AND DAY = (select max(day) from Quote where symbol = ?1)", nativeQuery = true)
	Quote findLatestQuoteBySymbol(String symbol);
	
	@Query(value ="select symbol, day, BID, ASK from Quote where SYMBOL = ?1 AND DAY = (select max(day) from Quote where symbol = ?1)", nativeQuery = true)
	List<Quote> findQuoteBySymbol(String symbol);
	
	//Retrieve the MAX ask by Date
	@Query(value ="select  q.symbol , q.day , q.bid, q.ask from quote q \r\n"
			+ "where q.day =?1\r\n"
			+ "order by ask desc\r\n"
			+ "limit 1\r\n"
			+ "", nativeQuery = true)
	List<Quote> findMaxAskByDate(String symbol);

}
