package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.*;

@RestController
public class MyController {

	@Autowired
	 MyConfiguration cfg;
	
	
	
	@GetMapping("/test")
	public String met()
	{
		return "this is message" + cfg;
		//cfg==>cfg.toString
	}
	
}
