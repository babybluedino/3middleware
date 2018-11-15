package com.myfirstboot.eg.com.myfirstboot.eg;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

	@GetMapping("/test")
	public String met()
	{
		return "this is webservice end point";
	}
}
