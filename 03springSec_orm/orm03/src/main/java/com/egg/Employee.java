package com.egg;

import java.util.Set;

public class Employee {
	private int id;
	private String name;
	private String dept;
	private Set address;
	
	public Employee(String name, String dept, Set address) {
		super();
		this.name = name;
		this.dept = dept;
		this.address = address;
	}

	//Getters and Setters
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Set getAddress() {
		return address;
	}
	public void setAddress(Set address) {
		this.address = address;
	}
}
