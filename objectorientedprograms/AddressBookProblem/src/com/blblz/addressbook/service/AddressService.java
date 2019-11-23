package com.blblz.addressbook.service;

import org.json.simple.JSONArray;

import com.blblz.addressbook.model.AddressModel;

public interface AddressService {

	public void defaultAddress();

	public JSONArray readAddress();

	public AddressModel addAddress();
}
