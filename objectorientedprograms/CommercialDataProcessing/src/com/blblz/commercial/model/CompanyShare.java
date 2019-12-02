package com.blblz.commercial.model;

public class CompanyShare {
	private String companyName;
	private String companySymbol;
	private int numberOfShare;
	private double price;
	private String dateTime;
	
	public CompanyShare(String cName, String symbol, int numberOfShare2, double price2, String dateTime2) {
		super();
		this.companyName = companyName;
		this.companySymbol = companySymbol;
		this.numberOfShare = numberOfShare;
		this.price = price;
		this.dateTime = dateTime;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanySymbol() {
		return companySymbol;
	}
	public void setCompanySymbol(String companySymbol) {
		this.companySymbol = companySymbol;
	}
	public int getNumberOfShare() {
		return numberOfShare;
	}
	public void setNumberOfShare(int numberOfShare) {
		this.numberOfShare = numberOfShare;
	}
	public double getPrice() {
		return price;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
