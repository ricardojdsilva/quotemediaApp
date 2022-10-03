package com.quotemedia.interview.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "QUOTE")
public class Quote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String symbol;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
	private String day;
	
	private Double BID;
	
	private Double ASK;
	
	
	public Quote() {
		
	}


	public Quote(String symbol, String daY, Double bID, Double aSK) {
		super();
		
		this.symbol = symbol;
		this.day = daY;
		BID = bID;
		ASK = aSK;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public Double getBID() {
		return BID;
	}


	public void setBID(Double bID) {
		BID = bID;
	}


	public Double getASK() {
		return ASK;
	}


	public void setASK(Double aSK) {
		ASK = aSK;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ASK, BID, day, symbol);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		return Objects.equals(ASK, other.ASK) && Objects.equals(BID, other.BID) && Objects.equals(day, other.day)
				&& Objects.equals(symbol, other.symbol);
	}



	
	
	
	
}
