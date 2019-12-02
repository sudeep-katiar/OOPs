package com.blblz.commercial.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.blblz.commercial.model.CompanyShare;
import com.blblz.commercial.util.Utility;

public class CompanyShareController {
	
public static CompanyShare companyDetails() {
		
		System.out.println("Enter Company Name");
		String cName = Utility.inputString();
		if(Utility.isStringOnlyAlphabet(cName)) {
			
		}
		
		System.out.println("Enter Company Symbol");
		String symbol = Utility.inputString();
		
		System.out.println("Enter Number of Share");
		int numberOfShare = Utility.inputinteger();
		
		
		System.out.println("Enter Price");
		double price = Utility.inputDouble();
		
		
		// will give us the current time and date 
	    LocalDateTime current = LocalDateTime.now(); 
	   // System.out.println("current date and time : "+ current); 
		// to print in a particular format 
	    DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd-MM-yyyy");   
	    
	    String dateTime = current.format(format);   
	     
	    //System.out.println("in foramatted manner "+ dateTime); 
	    
	    CompanyShare companyShare = new CompanyShare(cName,symbol,numberOfShare,price,dateTime);
		return companyShare;
	}

}
