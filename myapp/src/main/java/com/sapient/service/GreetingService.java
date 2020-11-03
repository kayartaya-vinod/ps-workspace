package com.sapient.service;

import com.sapient.entity.Greeting;

public class GreetingService {
	
	public Greeting getGreeting(String name) {
		
		if(name==null || name.trim().length()==0) {
			name = "friend";
		}
		
		String message = String.format("Hello, %s. How are you doing?", name);
		Greeting gr = new Greeting();
		gr.setMessage(message);
		return gr;
	}

}
