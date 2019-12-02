package com.blblz.clinique.utility;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;
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
			return sc.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}
	
	public static String inputStringLine() {
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
	
	public static void scannerClose() {
		try {
			sc.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void quit() {
		System.exit(0);
	}
	
	public static boolean stringChecker(String str) {
		char[] ch = str.toCharArray();
		String temp = "";
		Predicate<Character> p = s -> s >= 97 && s <= 122 || s >= 65 && s <= 90 || s >= 48 && s <= 57;
		for (char i : ch) {
			if (p.test(i)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Integer check
	 */
	public static boolean checkInteger(String number) {
		char ch[] = number.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 48 && ch[i] <= 57) {
				return true;
			}
		}
		return false;
	}

	/*
	 * @param-type: integer
	 * 
	 * @return-type: boolean
	 * 
	 */
	public boolean validOption(int option) {
		if (option == 1 || option == 2 || option == 3)
			return true;
		return false;
	}

	public static String doctorId() {
	    String output = "";
	    String doctorId = "DOC";
	    for (int i = 0 ; i < 3 ; i++){
	        output+=random.nextInt(10);
	    }
	    int outputInt = Integer.parseInt(output);
	    return doctorId+=outputInt;
		
	}
	
	public static String patientId() {
	    String output = "";
	    String doctorId = "PAT";
	    for (int i = 0 ; i < 3 ; i++){
	        output+=random.nextInt(10);
	    }
	    int outputInt = Integer.parseInt(output);
	    return doctorId+=outputInt;
		
	}
	
	public static boolean mobileNumberValidator(String number) {
		if(number.matches("^[789]\\d{9}$")) {
			return true;
		}
		return false;
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
