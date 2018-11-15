package com.myfirstboot.eg.com.myfirstboot.eg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/test")
	public String met()	
	{
		return "this is web service endpoint";	
	}
}
