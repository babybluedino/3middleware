package com.demo.spring.dao;

import java.util.List;

import com.mondodb.eg2.entity.*;

public interface UserDAO {

	//create user
	User createUser(User user);
		
	//retrieve user
	List<User> getAllUsers();
}








