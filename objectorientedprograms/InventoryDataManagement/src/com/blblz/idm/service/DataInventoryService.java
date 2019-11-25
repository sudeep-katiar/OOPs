package com.blblz.idm.service;

import com.blblz.idm.model.InventoryDetails;

public interface DataInventoryService {

	public void defaultInventory();

	public InventoryDetails addInventory();

	public void readInventory();

	public double getValue(double weight, double price);

}
