
//this interacts with mongoDB
//spring provides mongo template using which we can perform operation


package com.demo.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mondodb.eg2.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private MongoTemplate mTemplate;
	
	@Override
	public User createUser(User user) {
		mTemplate.save(user);
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return mTemplate.findAll(User.class);	
	}

	
}