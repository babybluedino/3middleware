package com.demo.spring;


import java.util.List;



public interface UserDao {

	//public User createUser(User user);
	public List<User> findAll();
	public User findUserById();
}


