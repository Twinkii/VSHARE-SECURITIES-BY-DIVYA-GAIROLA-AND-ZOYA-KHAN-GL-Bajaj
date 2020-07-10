package com.stockapp.VShare;

public class Stocks {
private String name;
private double price;
private String ticker;



public Stocks(String ticker, String name, double tempPrice1) {
	super();
	this.name=name;
	this.ticker=ticker;
	this.price=tempPrice1;
}
public String getName() {
    return this.name;
}

public void setName(String nam) {
    this.name = nam;
}
public String getTicker() {
    return this.ticker;
}

public void setTicker(String tic) {
    this.name = tic;
}
public double getPrice() {
    return this.price;
}

public void setPrice(double pri) {
    this.price = pri;
}




}
