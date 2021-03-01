package com.billr.tradesysv1.models;

public class MktOrder {
	

    private String side;
    private String symbol;
    private String type;
    private String qty;
    private String time_in_force;   
    private String limit_price;


    public String getLimit_price() {
		return limit_price;
	}
	public void setLimit_price(String limit_price) {
		this.limit_price = limit_price;
	}

	public void setSide(String side){
        this.side = side;
    }
    public String getSide(){
        return this.side;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public String getSymbol(){
        return this.symbol;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setQty(String qty){
        this.qty = qty;
    }
    public String getQty(){
        return this.qty;
    }
    public void setTime_in_force(String time_in_force){
        this.time_in_force = time_in_force;
    }
    public String getTime_in_force(){
        return this.time_in_force;
    }

}