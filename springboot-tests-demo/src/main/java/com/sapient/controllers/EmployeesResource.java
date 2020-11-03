package com.sapient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.entity.Employee;
import com.sapient.service.EmployeeManager;

@RestController
@RequestMapping("/api/employees")
public class EmployeesResource {

	@Autowired
	private EmployeeManager em;

	@GetMapping
	public List<Employee> getAll() {
		return em.getAll();
	}

	// .../api/employees?city=Bangalore
	@GetMapping(params = { "city" })
	public List<Employee> getByCity(@RequestParam String city) {
		return em.getAllByCity(city);
	}

	@PostMapping
	public void addNewEmployee(@RequestBody Employee emp) {
		em.addNewEmployee(emp);
	}

	// ... /api/employees/12
	@GetMapping("/{id}")
	public Employee getById(@PathVariable Integer id) {
		return em.getById(id);
	}

	// .../api/employees?email=john@example.com
	@GetMapping(params = { "email" })
	public Employee getByEmail(@RequestParam String email) {
		return em.getByEmail(email);
	}

}
