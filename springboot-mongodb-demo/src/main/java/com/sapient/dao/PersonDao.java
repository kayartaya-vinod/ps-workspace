package com.sapient.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.entity.Person;

@Repository
public interface PersonDao extends MongoRepository<Person, String> {

}
