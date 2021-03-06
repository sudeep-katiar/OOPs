package com.blblz.stockmanagement.serviceimplementation;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.blblz.stockmanagement.repository.StockRepository;
import com.blblz.stockmanagement.service.StockService;

public class StockServiceImplementation implements StockService {
	static JSONParser jsonParser = new JSONParser();
	static JSONObject jsonObject = new JSONObject();
	int n;

	@SuppressWarnings("unchecked")
	public void add(String stockname, int numberofshare, long stockprice) {
		JSONObject object = new JSONObject();

		// write data here
		object = StockRepository.json();
		JSONArray arr = new JSONArray();
		//System.out.println(arr);
		arr = (JSONArray) object.get("Stock");
     		//arr.add(obj2);
		JSONObject obj2 = new JSONObject();
		obj2.put("stock name", stockname);
		obj2.put("number of shares", numberofshare);
		obj2.put("stock price", stockprice);
		obj2.put("total", (numberofshare * stockprice));
		
		arr.add(obj2);
		//arr.add(obj2);
		try (PrintWriter pw = new PrintWriter("jsonfolder/stock.json")) {
			pw.write(object.toString());
			pw.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(object.toString());
	}	
	
	@SuppressWarnings("rawtypes")
	public void stockreport() {
		JSONObject jsonobject=new JSONObject();
		//to read jsonobject 
		jsonobject=StockRepository.json();
		
		JSONArray array=new JSONArray();
		array=(JSONArray)jsonobject.get("Stock");
		JSONObject obj = new JSONObject();
		Iterator itr=array.iterator();
		while(itr.hasNext())
		{
			System.out.println("Stock Name\tNo.of Stock\tStock Price\tStock Value\tTotal Value");
		obj=(JSONObject)itr.next();
	     System.out.print(obj.get("stock name").toString()+"\t\t");
	     System.out.print(obj.get("number of shares").toString()+"\t\t");
	     System.out.print(obj.get("stock price").toString()+"\t\t");
	     System.out.print(obj.get("total").toString()+"\t\t");
		}

	}
	
	public double valueOf()
	{
		
		return n;
		
	}
	
	public void buy(int amount, String symbol)
	{
		
	}
	
	public void sell(int amount, String symbol)
	{
		
	}
	
	public void save(String filename)
	{
		
	}
	
	public void printReport()
	{
		
	}
}
