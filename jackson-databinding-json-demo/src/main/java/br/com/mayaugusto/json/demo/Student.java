package br.com.mayaugusto.json.demo;

public class Student {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private boolean active;
	
	public Student() {}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public boolean isActive() {
		return active;
	}
	
	
}
