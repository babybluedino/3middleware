package com.demo.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Value("${message.special}")
	String wMessage;
	
	@GetMapping("/test")
	public String met()
	{
		return "this is message" + wMessage;
	}
	
}
