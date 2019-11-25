package com.blblz.addressbook.service;

import java.io.File;

import org.json.simple.JSONObject;

import com.blblz.addressbook.model.PersonModel;

public interface AddressService {

	public void store(PersonModel person);

	public void edit(File file, String name);

	public void delete(File file, String name);

	public JSONObject search(File file, String name);

	public void addAddressBook(String name);

	public void deleteAddressBook(String name);

	public File listOfFiles();

}
