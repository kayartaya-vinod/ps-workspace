package com.sapient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sapient.entity.Person;

@Service
public class PersonManager {

	List<Person> people = new ArrayList<>();
	
	public PersonManager() {
		people.add(new Person(1122, "John Doe", "johndoe@example.com", "Dallas" ));
		people.add(new Person(1256, "Allen Scott", "allenscott@example.com", "Paris" ));
		people.add(new Person(2315, "Ramesh Iyer", "rameshiyer@example.com", "Chennai" ));
		people.add(new Person(6753, "Rahul Dev", "rdev@example.com", "Kolkatta" ));
	}

	public List<Person> getAll() {
		return people;
	}

	public Person getById(Integer id) {
		List<Person> lst = people.stream().filter(p -> p.getId().equals(id)).collect(Collectors.toList());

		return lst.isEmpty() ? null: lst.get(0);
	}

}
