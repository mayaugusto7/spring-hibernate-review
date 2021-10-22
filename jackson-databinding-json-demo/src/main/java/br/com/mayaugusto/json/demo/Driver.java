package br.com.mayaugusto.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// Create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// Read JSON file and map/convert to Java POJO data/sample.lite.json
			Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			// Print first name and last name
			System.out.println("First name: " + student.getFirstName());
			System.out.println("Last name: " + student.getLastName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
