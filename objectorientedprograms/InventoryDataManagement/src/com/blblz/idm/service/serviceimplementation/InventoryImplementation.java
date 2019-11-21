package com.blblz.idm.service.serviceimplementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.blblz.idm.model.InventoryDetails;
import com.blblz.idm.util.Utility;

public class InventoryImplementation {
	
	 Utility utility = new Utility();
	 String path="/home/admin1/bridgelabz/objectorientedprograms/InventoryDataManagement/DataManagement.json";
	 
	 @SuppressWarnings("unchecked")
	public void defaultInventory()
		{
			JSONObject obj = new JSONObject();
			
			JSONArray list = new JSONArray();

			list.add("Name: Basmati");
			list.add("Weight: 20kg");
			list.add("Price: Rs500");
			
			obj.put("Rice", list.clone());
			
			list.clear();
			list.add("Name: Dumur");
			list.add("Weight: 3kg");
			list.add("Price: Rs100");
			
			obj.put("Wheat", list.clone());
			
			list.clear();
			list.add("Name: Peas");
			list.add("Weight: 5kg");
			list.add("Price: Rs600");
			
			obj.put("Pulses", list);
			
			try(FileWriter file = new FileWriter("DataManagement.json"))
			{
				file.write(obj.toJSONString());
				file.flush();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			System.out.println(obj);
		}
	 
	 /**
	  * Takes user input and writes data to JSON object and object to file
	  */
	@SuppressWarnings({ "static-access", "unchecked" })
	public InventoryDetails addInventory()
	 {
		InventoryDetails inventory = new InventoryDetails();
		String[] names=new String[] {"rice", "wheat", "pulses"};
		JSONObject finalObject = new JSONObject();
		for(String name: names)
		{
			System.out.print("Enter number of types of " + name + " : ");
			int count = utility.inputInteger();	//	types of every inventory
			JSONArray array = new JSONArray();	//	array to store types
			
			for(int i = 0; i < count; i++) 
			{	//	 object for every type
				JSONObject jsonObject  = new JSONObject();
				System.out.print("Enter name, weight and price: ");
				jsonObject.put("name", utility.inputStringLine());
				jsonObject.put("weight", utility.inputDouble());
				jsonObject.put("price", utility.inputDouble());
				array.add(jsonObject);
			}
			finalObject.put(name , array);
		}
		try(PrintWriter printWriter = new PrintWriter(path)) {
			printWriter.write(finalObject.toJSONString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Enter the product name: ");
		inventory.setName(utility.inputString());
		inventory.getName();
		
		System.out.println("Enter the weight");
		inventory.setWeight(utility.inputDouble());
		inventory.getWeight();

		System.out.println("Enter the Price");
		inventory.setPrice(utility.inputDouble());
		inventory.getPrice();
		
		return inventory;
	}
	
	/**
	 * reads data from JSON file and 
	 * prints inventory value of Rice, Pulses and Wheat
	 */
	 @SuppressWarnings("unchecked")
	 
		public void readInventory() {
			JSONParser parser = new JSONParser();
			
			try
			{
				Object obj = parser.parse(new FileReader("/home/admin1/bridgelabz/objectorientedprograms/InventoryDataManagement/DataManagement.json"));
				JSONArray jsonArray = (JSONArray)obj;
				
				//loop array
				JSONArray riceArray = (JSONArray) jsonObject.get("Rice");
				Iterator<String> iterator = riceArray.iterator();
				
				while(iterator.hasNext())
				{
					System.out.println("Rice: "+iterator.next());
				}
				
				JSONArray wheatArray = (JSONArray) jsonObject.get("Wheat");
				Iterator<String> iterator1 = wheatArray.iterator();
				
				while(iterator1.hasNext())
				{
					System.out.println("Wheat: "+iterator1.next());
				}
				
				JSONArray pulsesArray = (JSONArray) jsonObject.get("Pulses");
				Iterator<String> iterator2 = pulsesArray.iterator();
				
				while(iterator2.hasNext())
				{
					System.out.println("Pulses: "+iterator2.next());
				}
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			catch(ParseException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	 	}
	
	/**
	* array - JSON array
	* value of given inventory array
	*/
	
	public double getValue(JSONArray array){
		Iterator<?> iterator = array.iterator();	//	iterator to iterate
		double value = 0;	//	inventory value
		
		while(iterator.hasNext())
		{
			JSONObject obj = (JSONObject)iterator.next();
			double weight = (double)obj.get("Weight");
			double price = (double)obj.get("Price");
			value = value + weight * price;	//	adding value
		}
		return value;
	}

}
