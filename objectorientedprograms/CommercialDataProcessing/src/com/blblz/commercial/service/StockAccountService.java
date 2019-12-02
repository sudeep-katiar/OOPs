package com.blblz.commercial.service;

import java.io.File;

import com.blblz.commercial.model.CompanyShare;

public interface StockAccountService {
	void addCompanyDetails(File file, CompanyShare companyDetails);

	void buyShare(double amount, String symbol, File file2);

	void sellShare(double amount, String symbol, File file2);

	void printReport();

	void removeCompanyDetails(String symbol);

	void printTransactionDetails();

}
