package com.sapient.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sapient.entity.Employee;
import com.sapient.repository.EmployeesRepository;
import com.sapient.service.EmployeeManager;
import com.sapient.service.ServiceException;

@SpringBootTest
class TestEmployeeManager {

	@Autowired
	EmployeeManager em;

	@MockBean
	EmployeesRepository repo;

	Employee emp;

	@BeforeEach
	void setup() {
		emp = new Employee(1, "Shyam", "shyam@xmpl.com", 4590.0, "Bangalore");
		Mockito.when(repo.insert(emp)).thenReturn(emp);
	}

	@Test
	void shouldAddNewEmployee() {
		Employee e1 = em.addNewEmployee(emp);
		Assertions.assertEquals(e1.getName(), "Shyam");
	}

	@Test
	void shouldNotAddEmployeeWithEmptyName() {
		Employee emp2 = new Employee();
		emp2.setName("   ");
		Assertions.assertThrows(ServiceException.class, () -> em.addNewEmployee(emp2));
	}

	@Test
	void shouldNotAddEmployeeWithNullName() {
		Employee emp2 = new Employee();
		Assertions.assertThrows(ServiceException.class, () -> em.addNewEmployee(emp2));
	}

	@Test
	void shouldNotAddNullEmployee() {
		Assertions.assertThrows(ServiceException.class, () -> em.addNewEmployee(null));
	}

}




