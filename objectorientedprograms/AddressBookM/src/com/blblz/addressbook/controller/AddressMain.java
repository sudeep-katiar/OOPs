package com.blblz.addressbook.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.blblz.addressbook.model.Person;
import com.blblz.addressbook.repository.Connector;
import com.blblz.addressbook.serviceimplementation.Operation;
import com.blblz.addressbook.utility.Utility;

public class AddressMain {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		Connector connection = new Connector();
		Operation operation = new Operation();

		do {
			System.out.println("choose your option");
			System.out.println("=======================");
			System.out.println("1.add person");
			System.out.println("2.delete person");
			System.out.println("3.edit person details");
			System.out.println("4.sort the user name by last name");
			System.out.println("5.print user details by first name");

			int choice = Utility.intScanner();

			switch (choice) {

			case 1:
				List<Person> info = connection.readFile();
				List<Person> personlist = operation.addUser(info);
				connection.writeFile(personlist);
				// System.out.println("for more operation enter true");
				break;

			case 2:
				List<Person> info1 = connection.readFile();
				boolean listOfPerson = operation.deleteUser(info1);
				if (listOfPerson == true) {
					System.out.println("data deleted successfully");
				} else {
					System.out.println("data not found");
				}
				connection.writeFile(info1);
				break;

			case 3:
				List<Person> info3 = connection.readFile();
				operation.editUser(info3);
				connection.writeFile(info3);
				break;

			case 4:
				List<Person> info4 = connection.readFile();
				operation.sortUser(info4);
//				System.out.println(personList.toString());
//				connection.writeFile(info4);
				break;

			case 5:
				List<Person> info5 = connection.readFile();
				operation.printUser(info5);
				break;

			}
			System.out.println("for more operation enter true");
		} while (Utility.booleanScanner());
		System.out.println("operation performed successfully.....");
	}

}
