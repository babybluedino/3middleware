package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan("com.demo.spring")
@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	UserDaoImpl udao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("1....");
		List<User> luser = udao.findAll();
		
		System.out.println("2...");
		for(User user : luser)
		{
			System.out.println("3....");
			System.out.println(user);
		}
	}
}
