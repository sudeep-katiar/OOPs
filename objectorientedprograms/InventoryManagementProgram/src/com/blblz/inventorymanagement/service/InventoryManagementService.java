package com.blblz.inventorymanagement.service;

import org.json.simple.JSONArray;

import com.blblz.inventorymanagement.model.InventoryModel;

public interface InventoryManagementService {
	public void defaultInventory();
	public InventoryModel addInventory();
	public void readInventory();
	public double getValue(JSONArray array);
}
