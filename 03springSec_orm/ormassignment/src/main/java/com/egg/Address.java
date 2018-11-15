package com.egg;

public class Address {

	private int addressId;
	private String city;
	private String state;
	private  Building building;
	
	
	public Address(String city, String state, Building building) {
		super();
		this.city = city;
		this.state = state;
		this.building = building;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
}
