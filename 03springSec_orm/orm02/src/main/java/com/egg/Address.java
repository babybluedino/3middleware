package com.egg;

public class Address {

	private int id;
	private String street;
	private String city;
	
	public Address(String street, String city) {
		
		//this.id = id;
		this.street = street;
		this.city = city;
	}

	public Address() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
