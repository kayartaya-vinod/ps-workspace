package com.sapient.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.dao.EmployeeDao;

@Controller
public class EmployeesController {

	@Autowired
	private EmployeeDao dao;
	
	// handler function to handle /emps-by-sal-range?min=4000&max=10000
	@RequestMapping("/emps-by-sal-range")
	public String empsBySalRange(@RequestParam Double min, @RequestParam Double max, Model model) {
		model.addAttribute("emps", dao.getEmployeesBySalaryRange(min, max));
		return "show-employees";// view resolver converts this into --> /WEB-INF/views/show-employees.jsp
	}

}
