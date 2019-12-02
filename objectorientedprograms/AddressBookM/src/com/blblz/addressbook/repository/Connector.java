package com.blblz.addressbook.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.blblz.addressbook.model.Person;

public class Connector {

	Person details = new Person();
	static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}
	File file = new File("address.json");

	/*
	 * FOR READ THE FILE -------------------
	 */
	public List<Person> readFile() throws IOException {

		List<Person> info = mapper.readValue(file, new TypeReference<List<Person>>() {
		});

		return info;

	}
	/*
	 * FOR WRITE IN A FILE --------------------
	 */

	public void writeFile(List<Person> personlist) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(file, personlist);

	}

}
