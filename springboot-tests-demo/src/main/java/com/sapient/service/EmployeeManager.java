package com.sapient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.entity.Employee;
import com.sapient.repository.EmployeesRepository;

@Service
public class EmployeeManager {

	@Autowired
	EmployeesRepository repo;
	
	public Employee addNewEmployee(Employee emp) {
		if(emp==null) {
			throw new ServiceException("Parameter emp cannot be null");
		}
		
		if(emp.getName()==null || emp.getName().trim().length()==0) {
			throw new ServiceException("Name cannot be null or empty string.");
		}
		return repo.insert(emp);
	}
	
	public Employee getById(Integer id) {
		return repo.findById(id).get();
	}
	
	public Employee getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public List<Employee> getAll() {
		return repo.findAll();
	}
	
	public List<Employee> getAllByCity(String city) {
		return repo.findByCity(city);
	}
	
}
