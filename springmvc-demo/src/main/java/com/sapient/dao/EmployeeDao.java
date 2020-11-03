package com.sapient.dao;

import java.util.List;

import com.sapient.entity.Employee;

public interface EmployeeDao {
	// CRUD operations (will not be done)
	
	// QUERIES
	public List<Employee> getEmployeesBySalaryRange(Double min, Double max);
}
