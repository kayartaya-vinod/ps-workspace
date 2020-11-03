package com.sapient.training.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sapient.training.entity.Person;

class TestPerson {
	Person p;
	
	
	@BeforeEach
	void init() {
		p = new Person();
	}
	
	@Test
	void testPerson() {
		p.setName("Vinod");
		Assertions.assertEquals("Vinod", p.getName());
	}
}
