package com.blblz.stockmanagement.model;

public class StockModel {
	private String stockname;
	private int numberofshare;
	private long shareprice;

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public int getNumberofshare() {
		return numberofshare;
	}

	public void setNumberofshare(int numberofshare) {
		this.numberofshare = numberofshare;
	}

	public long getShareprice() {
		return shareprice;
	}

	public void setShareprice(long shareprice) {
		this.shareprice = shareprice;
	}

}
