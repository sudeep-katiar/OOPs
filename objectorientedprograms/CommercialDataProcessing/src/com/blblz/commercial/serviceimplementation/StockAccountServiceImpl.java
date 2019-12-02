package com.blblz.commercial.serviceimplementation;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.blblz.commercial.model.CompanyShare;
import com.blblz.commercial.repository.StockAccountRepository;
import com.blblz.commercial.service.StockAccountService;
import com.blblz.commercial.util.MyQueue;
import com.blblz.commercial.util.MyStack;

public class StockAccountServiceImpl implements StockAccountService{
	
	String path = "JsonFile/CompanyList.json";
	File fileRead = new File(path);
	MyStack<String> transactionStack;
	MyQueue<String> transactionQueue;
	CompanyShare[] companyShares;

	public StockAccountServiceImpl() {
		transactionStack = new MyStack<>();
		transactionQueue = new MyQueue<>();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void addCompanyDetails(File file, CompanyShare companyDetails) {
		JSONObject jsonObject = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject baseJson = (JSONObject) StockAccountRepository.readData(file);
		JSONObject json = (JSONObject) baseJson.get("STOCK MARKET");

		jsonObject.put("CompanyName", companyDetails.getCompanyName());
		jsonObject.put("CompanySymbol", companyDetails.getCompanySymbol());
		jsonObject.put("NumberOfShare", companyDetails.getNumberOfShare());
		jsonObject.put("Price", companyDetails.getPrice());
		jsonObject.put("Date", companyDetails.getDateTime());

		array.add(jsonObject);
		json.put(companyDetails.getCompanySymbol(), array);

		StockAccountRepository.writeData(file, baseJson);
	}

	@Override
	public void printReport() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public void buyShare(double amount, String symbol, File fileWrite) {
		int count = 0;
		double price = 0;
		JSONArray array, jsonArray = null;

		JSONObject jsonObject = StockAccountRepository.readData(fileRead);
		JSONObject json = (JSONObject) jsonObject.get("STOCK MARKET");
		System.out.println(json);
		if((array = (JSONArray) json.get(symbol))!=null) {
			jsonArray = array;
			Iterator<?> iterator = array.iterator();
			while (iterator.hasNext()) {
				JSONObject cDetails = (JSONObject) iterator.next();
				price = (double) cDetails.get("Price");
			}

			int numberOfShare = (int) Math.round(amount / price);
			System.out.println("Share :" + numberOfShare);

			array = updateCompanyDetails(jsonArray, numberOfShare);
			LocalDateTime current = LocalDateTime.now();
			// System.out.println("current date and time : "+ current);
			// to print in a particular format
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

			String dateTime = current.format(format);
			
			JSONObject accountObject = new JSONObject();
			accountObject.put("Symbol", symbol);
			accountObject.put("PurchaseShare", numberOfShare);
			accountObject.put("PurchaseTime", dateTime);
			accountObject.put("Price", price);

			JSONArray array2 = new JSONArray();
			array2.add(accountObject);

			StockAccountRepository.writeData(fileRead, jsonObject);
			StockAccountRepository.writeData(fileWrite, array2);
			
			transactionStack.push("Purchased");
			transactionQueue.enqueue(dateTime);
		}
		else {
			System.out.println("The Stock you are trying to purchase is not available in Stock Market");
		}
		
	}

	private JSONArray updateCompanyDetails(JSONArray jsonArray, int numberOfShare) {
		long updatedShare = 0;

		Iterator<?> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			JSONObject type = (JSONObject) iterator.next();
			updatedShare = (long) type.get("NumberOfShare");
			System.out.println("updated share " + updatedShare);
			if (numberOfShare > updatedShare) {
				System.out.println("Number of Share should be less than total share which is :" + updatedShare);
			} else {
				updatedShare = updatedShare - numberOfShare;
				type.put("NumberOfShare", updatedShare);
			}
		}
		return jsonArray;
	}

	@Override
	public void sellShare(double amount, String symbol, File file2) {
		double price = 0;
		JSONArray jsonArray = StockAccountRepository.readArrayData(file2);
		if (jsonArray.size() != 0) {
			Iterator<?> iterator = jsonArray.iterator();
			JSONObject jsonObject, accountJson = null;
			while (iterator.hasNext()) {
				if ((jsonObject = (JSONObject) iterator.next()).get("Symbol").equals(symbol)) {
					if (jsonObject.get("PurchaseShare") != null) {
						accountJson = jsonObject;
						price = (double) jsonObject.get("Price");
					}
				}
			}
			int numberOfShare = (int) Math.round(amount / price);
			System.out.println("Share :" + numberOfShare);
			
			jsonObject = updateAccountDetails(accountJson, numberOfShare);

			StockAccountRepository.writeData(file2, jsonArray);
		} else {
			System.out.println("You doesn't have any share please buy some share berfore selling\n");
		}
	}

	private JSONObject updateAccountDetails(JSONObject accountJson, int numberOfShare) {
		long share = (long) accountJson.get("PurchaseShare");
		long updatedShare = 0;
		String dateTime = "";
		if (share > numberOfShare) {
			updatedShare = share - numberOfShare;
			accountJson.put("SoldShare", updatedShare);
			LocalDateTime current = LocalDateTime.now();
			// to print in a particular format
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

			dateTime = current.format(format);
			transactionStack.push("Sold");
			transactionQueue.enqueue(dateTime);

		} else {
			System.out.println("You are trying to sell Over limit you habve only " + share + " share");
		}

		accountJson.put("SoldTime", dateTime);

		return accountJson;
	}

	@Override
	public void removeCompanyDetails(String symbol) {
		// JSONArray jsonArray = StockAccountRepository.readArrayData(file)
	}
	
	@Override
	public void printTransactionDetails() {
		/**
		 * prints queue
		 */

			System.out.println("\nTransactions Queue:");
			while (!transactionQueue.isEmpty()) {
				System.out.println(transactionQueue.dequeue());
			}
	
		
		/**
		 * prints stack
		 */
			System.out.println("\nTransactions Stack:");
			while (!transactionStack.isEmpty()) {
				System.out.println(transactionStack.pop());
			}
		
	}
	
	/**
	 * prints detailed report 
	 */
	/*public void printReportNew() {
		System.out.println("\n" + name + "\n");
		System.out.println("Symbol\tNo. of Shares\tPrice\tValue\tDate");
		for (int i = 0; i < count; i++) {
			CompanyShares shares = companyShares[i];
			System.out.println(shares.getSymbol() + "\t" + shares.getNumberOfShares() + "\t\t" + shares.getPrice()
					+ "\t" + shares.getValue() + "\t" + shares.getDateTime());
		}			
	}*/

}
