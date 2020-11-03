package com.sapient.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.entity.Employee;

@Repository
public class HibernateTemplateEmployeeDao implements EmployeeDao {
	
	// this is a dependency; must be wired
	@Autowired
	HibernateTemplate template;

	@Override
	public List<Employee> getEmployeesBySalaryRange(Double min, Double max) {
		return (List<Employee>) template.find("from Employee where salary between ?0 and ?1", min, max);
	}

}
