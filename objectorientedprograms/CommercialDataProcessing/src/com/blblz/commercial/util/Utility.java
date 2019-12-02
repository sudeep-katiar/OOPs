package com.blblz.commercial.util;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	static Scanner sc = new Scanner(System.in);
	static Random random = new Random();
	
	// Function to check String for only Alphabets 
    public static boolean isStringOnlyAlphabet(String str) 
    { 
        return ((str != null) 
                && (!str.equals("")) 
                && (str.matches("^[a-zA-Z]*$"))); 
    } 
    
    public static int inputinteger() {
		try {
			return sc.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static String inputString() {
		try {
			return sc.nextLine();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}
	
	public static long inputLong() {
		try {
			return sc.nextLong();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static double inputDouble() {
		try {
			return Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static void scannerClose() {
		try {
			sc.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static boolean intChecker(String number) {
		// regular expression for an integer number 
        String regex = "[+-]?[0-9][0-9]*"; 
        
     // compiling regex 
        Pattern p = Pattern.compile(regex); 
        
     // Creates a matcher that will match input1 against regex 
        Matcher m = p.matcher(number);
        
        if(m.find() && m.group().equals(number)) 
        	return true;
        
		return false;
		
	}

}
