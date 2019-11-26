package com.blblz.stockmanagement.controller;

import java.util.Scanner;

import com.blblz.stockmanagement.service.StockService;
import com.blblz.stockmanagement.serviceimplementation.StockServiceImplementation;

public class StockController {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		StockService stock = new StockServiceImplementation();
		Scanner enter = new Scanner(System.in);

		int ch = 0;

		do {
			System.out.println("please enter option.\n1. add stock \n2. calculate stock. \n3. exit");
			switch (enter.nextLine()) {
			case "1":

				System.out.println("enter name");
				String stockname = enter.nextLine();
				System.out.println("enter number of shares");
				int numberofshare = enter.nextInt();
				System.out.println("enter share price ");
				long stockprice = enter.nextLong();
				stock.add(stockname, numberofshare, stockprice);

//			stock.add();
				break;
			case "2":

				System.out.println("stock report");
				stock.stockreport();
				break;

			case "3":

				ch++;
			}
		} while (ch == 0);
	}

}
