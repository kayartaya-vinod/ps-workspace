package com.sapient.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // every handler method returns ResponseBody
public class HomeController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello, World! Have a nice day.";
	}
}
