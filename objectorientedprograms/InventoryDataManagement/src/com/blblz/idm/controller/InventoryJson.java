package com.blblz.idm.controller;

import com.blblz.idm.service.DataInventoryService;
import com.blblz.idm.serviceimplementation.InventoryImplementation;

public class InventoryJson {
	public static void main(String[] args) {
		DataInventoryService details = new InventoryImplementation();
		details.defaultInventory();
		details.readInventory();
//		details.getValueOne(obj);
	}
}
