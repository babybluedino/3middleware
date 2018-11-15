package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	CustomerRepository crepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		crepo.save(new Customer(1,"Dino","1111",23));
		crepo.save(new Customer(2,"Popo","222",45));
		crepo.save(new Customer(3,"Roro","3333",34));
		
	}
}
