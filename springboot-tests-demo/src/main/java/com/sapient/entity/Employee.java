package com.sapient.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "emps")
public class Employee {
	@Id
	private Integer id;
	private String name;
	private String email;
	private Double salary;
	private String city;
}
