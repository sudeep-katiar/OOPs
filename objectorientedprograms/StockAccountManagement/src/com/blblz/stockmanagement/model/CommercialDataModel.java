package com.blblz.stockmanagement.model;

public class CommercialDataModel {
	private String symbol;
	private String name;
	private long numOfShare;
	private long price;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumOfShare() {
		return numOfShare;
	}

	public void setNumOfShare(long numOfShare) {
		this.numOfShare = numOfShare;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}