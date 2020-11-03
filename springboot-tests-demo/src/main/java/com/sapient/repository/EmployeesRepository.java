package com.sapient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sapient.entity.Employee;

public interface EmployeesRepository extends MongoRepository<Employee, Integer> {
	
	public Employee findByEmail(String email);
	
	public List<Employee> findByCity(String city);
	
}
