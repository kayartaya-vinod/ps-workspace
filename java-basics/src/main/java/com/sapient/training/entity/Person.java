package com.sapient.training.entity;

import lombok.Data;

@Data
public class Person {

	private String name;
	private int age;
	private double height;

	public void setAge(int age) {
		if (age < 0 || age > 120) {
			throw new RuntimeException("Invalid age");
		}
		this.age = age;
	}
}
