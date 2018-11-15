package com.egg;

public class Employee {

	private int id;
	private String name;
	private Address address;
	private int salary;
	
	
	public Employee(String name, Address address,int salary) {
		super();
		this.name = name;
		this.address = address;
		this.salary=salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
