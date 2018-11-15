package com.mondodb.eg2.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String userId;
	private String  name;
	private Map<String, String>nmss = new HashMap<>();

	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getNmss() {
		return nmss;
	}
	public void setNmss(Map<String, String> nmss) {
		this.nmss = nmss;
	}
}
