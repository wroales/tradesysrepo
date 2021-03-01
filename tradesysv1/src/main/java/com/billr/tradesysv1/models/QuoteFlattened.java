package com.billr.tradesysv1.models;

import java.util.Date;

public class QuoteFlattened {

	private String symbol;
    private double askprice;
    private int asksize;
    private int askexchange;
    private double bidprice;
    private int bidsize;
    private int bidexchange;
    private Date qDate;
 
    public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getAskprice() {
		return askprice;
	}
	public void setAskprice(double askprice) {
		this.askprice = askprice;
	}
	public int getAsksize() {
		return asksize;
	}
	public void setAsksize(int asksize) {
		this.asksize = asksize;
	}
	public int getAskexchange() {
		return askexchange;
	}
	public void setAskexchange(int askexchange) {
		this.askexchange = askexchange;
	}
	public double getBidprice() {
		return bidprice;
	}
	public void setBidprice(double bidprice) {
		this.bidprice = bidprice;
	}
	public int getBidsize() {
		return bidsize;
	}
	public void setBidsize(int bidsize) {
		this.bidsize = bidsize;
	}
	public int getBidexchange() {
		return bidexchange;
	}
	public void setBidexchange(int bidexchange) {
		this.bidexchange = bidexchange;
	}
	public Date getqDate() {
		return qDate;
	}
	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}
			
}