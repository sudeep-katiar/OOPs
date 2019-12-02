package com.blblz.commercial.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockAccountRepository {
	static JSONParser jsonParser = new JSONParser();
	static JSONArray array = null;

	public static void writeData(File file, JSONObject baseJson) {
		try(FileWriter fileWriter = new FileWriter(file)){
			fileWriter.write(baseJson.toJSONString());
			System.out.println("Data added to the "+file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject readData(File file) {
		
		try(FileReader fileReader = new FileReader(file)){
			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
			return jsonObject;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void writeData(File fileWrite, JSONArray array2) {
		try(FileWriter fileWriter = new FileWriter(fileWrite)){
			fileWriter.write(array2.toJSONString());
			fileWriter.flush();
			System.out.println("Data added into the "+fileWrite);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JSONArray readArrayData(File file) {
		try(FileReader fileReader = new FileReader(file)){
			array =  new JSONArray();
			array = (JSONArray) jsonParser.parse(fileReader);
			return array;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
