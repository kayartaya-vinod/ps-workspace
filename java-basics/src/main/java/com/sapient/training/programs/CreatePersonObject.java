package com.sapient.training.programs;

import com.sapient.training.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatePersonObject {

	public static void main(String[] args) {
		
		Person p1; // 8 bytes in stack

		p1 = new Person();
		log.info("p1 is {}", p1);

		p1.setName("Vinod");
		p1.setAge(47);
		p1.setHeight(5.8);

		log.debug("Name is {}, age is {} years and height is {} ft.", p1.getName(), p1.getAge(), p1.getHeight());
		log.info("p1 is {}", p1.toString());
	}
}
