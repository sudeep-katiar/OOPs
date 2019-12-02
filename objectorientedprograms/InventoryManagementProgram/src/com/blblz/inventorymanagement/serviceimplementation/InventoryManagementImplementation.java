package com.blblz.inventorymanagement.serviceimplementation;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.blblz.inventorymanagement.model.InventoryModel;
import com.blblz.inventorymanagement.service.InventoryManagementService;
import com.blblz.inventorymanagement.utility.Utility;

public class InventoryManagementImplementation implements InventoryManagementService {
	Utility utility = new Utility();

	@SuppressWarnings({ "unchecked" })
	public void defaultInventory() {
		JSONObject obj1 = new JSONObject();

//		JSONArray list = new JSONArray();
		// first item
		obj1.put("Name", "Rice");
		obj1.put("Weight", 10.0);
		obj1.put("Price", 100.0);
		JSONObject type1 = new JSONObject();
		type1.put("Item", obj1);
		// second item
		JSONObject obj2 = new JSONObject();
		obj2.put("Name", "Wheat");
		obj2.put("Weight", 20.0);
		obj2.put("Price", 500.0);
		JSONObject type2 = new JSONObject();
		type2.put("Item", obj2);

		// third item
		JSONObject obj3 = new JSONObject();
		obj3.put("Name", "Pulses");
		obj3.put("Weight", 30.0);
		obj3.put("Price", 1000.0);
		JSONObject type3 = new JSONObject();
		type3.put("Item", obj3);

		// Add items to list
		JSONArray items = new JSONArray();
		items.add(type1);
		items.add(type2);
		items.add(type3);

		try (FileWriter file = new FileWriter("InventoryManagement.json")) {
			file.write(items.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(items);
	}
	
	/**
	 * reads data from JSON file and prints inventory value of Rice, Pulses and
	 * Wheat
	 */
	@SuppressWarnings("unchecked")
	public void readInventory() {

		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(
				"/home/admin1/bridgelabz/objectorientedprograms/InventoryManagementProgram/InventoryManagement.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray allItems = (JSONArray) obj;
//			System.out.println(allItems);

			// Iterate over all items array
			allItems.forEach(emp -> parseItemObject((JSONObject) emp));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parseItemObject(JSONObject item) {
		// Get item object within list
		JSONObject itemObject = (JSONObject) item.get("Item");

		// Get item type
		String name = (String) itemObject.get("Name");
		System.out.println(name);

		// Get item weight
		Double weight = (Double) itemObject.get("Weight");
		System.out.println(weight);

		// Get item price
		Double price = (Double) itemObject.get("Price");
		System.out.println(price);

		double value = getValue(weight, price);
		System.out.println("total Value :" + value);

	}

	/**
	 * array - JSON array get value of given inventory array
	 */

	public double getValue(double weight, double price) {
		double value = 0.0;
		value = value + (weight * price);
		return value;
	}
	

	/**
	 * Takes user input and writes data to JSON object and object to file
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	public InventoryModel addInventory() {
		InventoryModel inventory = new InventoryModel();
		String[] names = new String[] { "Item" };
//		JSONObject finalObject = new JSONObject();

		System.out.print("Enter number of types of item");
		int choice = utility.inputInteger();
		JSONArray array = new JSONArray();
		for (int i = 0; i < names.length; i++) {
			// types of every inventory
			while (choice != 0) {
				// array to store types
				JSONObject jsonObject = new JSONObject();
				System.out.print("Enter name, weight and price: ");
				jsonObject.put("Name", utility.inputString());
				jsonObject.put("Weight", utility.inputDouble());
				jsonObject.put("Price", utility.inputDouble());
				
				JSONObject objOne=new JSONObject();
				objOne.put("Item", jsonObject);
				
				array.add(objOne);
				
				choice--;
		
		try (BufferedWriter br = new BufferedWriter(new FileWriter("InventoryManagement.json"))) {
			br.write(array.toJSONString());
//			System.out.println(array);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			}
		}
//		System.out.println("Enter the product name: ");
//		inventory.setName(utility.inputString());
//		inventory.getName();
//
//		System.out.println("Enter the weight");
//		inventory.setWeight(utility.inputDouble());
//		inventory.getWeight();
//
//		System.out.println("Enter the Price");
//		inventory.setPrice(utility.inputDouble());
//		inventory.getPrice();

		return inventory;
	}

	public static void main(String[] args) {
		InventoryManagementImplementation m = new InventoryManagementImplementation();
		m.addInventory();
	}
	
}
