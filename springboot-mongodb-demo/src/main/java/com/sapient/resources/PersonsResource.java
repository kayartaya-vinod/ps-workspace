package com.sapient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.PersonDao;
import com.sapient.entity.Person;

@RestController
@RequestMapping("/api/persons")
public class PersonsResource {
	
	// An object of a dynamically created class (by spring boot) is injected on the fly
	@Autowired
	private PersonDao dao;
	
	@PostMapping
	public void addPeson(@RequestBody Person person) {
		dao.insert(person);
	}
	
	@GetMapping
	public List<Person> getAll() {
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Person getById(@PathVariable String id) {
		return dao.findById(id).get();
	}

}
