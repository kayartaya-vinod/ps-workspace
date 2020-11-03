package com.sapient.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "people")
@Data
public class Person {
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String city;

}
