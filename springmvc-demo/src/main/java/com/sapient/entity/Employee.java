package com.sapient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@Column(name="employee_id")
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private Double salary;

}
