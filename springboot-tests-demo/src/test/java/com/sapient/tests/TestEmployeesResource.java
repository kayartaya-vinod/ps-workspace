package com.sapient.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.controllers.EmployeesResource;

@SpringBootTest
class TestEmployeesResource {

	@Autowired
	EmployeesResource resource;
	
	@Test
	void testContext() {
		Assertions.assertNotNull(resource);
	}
	
	
}
