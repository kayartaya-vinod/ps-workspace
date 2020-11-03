package com.sapient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.entity.Person;
import com.sapient.service.PersonManager;

@RestController
@RequestMapping("/api/persons")
public class PersonsResource {

	@Autowired
	private PersonManager pm;

	@GetMapping
	public List<Person> getAll() {
		return pm.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> getById(@PathVariable Integer id) {
		Person p = pm.getById(id);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(p);
	}
}
