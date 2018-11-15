package com.demo.spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.demo.spring.dao.UserDAO;
import com.mondodb.eg2.entity.User;

@RestController
@RequestMapping(value = "/")
public class UserController {
	
	private final UserDAO userdao;
	
	//private final UserRepository userRepository;

	public UserController(UserDAO userdao) {
		//this.userRepository = userRepository;
		this.userdao = userdao;
	}
	
/*
	 http://localhost:8102/user/create
	 {
 "name" : "Ramu",
 "userSettings" : {
   "bike" : "pulsar"
 }
}*/
	//create user
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public User createUser(@RequestBody User user)
	{
		//return userRepository.save(user);
		return userdao.createUser(user);
	}
	
	//get all users
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<User> getAllUsers()
	{
		//return userRepository.findAll();
		return userdao.getAllUsers();
	}
}
