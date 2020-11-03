package com.sapient.web.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sapient.dao.EmployeeDao;
import com.sapient.entity.Employee;

@Controller
public class EmployeesResource {

	@Autowired
	EmployeeDao dao;
	
	@RequestMapping(method = RequestMethod.GET, path="/api/employees")
	@ResponseBody
	public List<Employee> getAllEmps() {
		return dao.getEmployeesBySalaryRange(0., 1000000.);
	}
}
