package com.sapient.tests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.entity.Employee;
import com.sapient.service.EmployeeManager;

@SpringBootTest
@AutoConfigureMockMvc
class TestMvcRequests {

	@Autowired
	private MockMvc mockMvc; // allows us to perform HTTP requests

	@MockBean
	private EmployeeManager em;

	ObjectMapper om;

	@BeforeEach
	void setup() {
		om = new ObjectMapper();

		List<Employee> emps = Arrays.asList(new Employee(1, "Vinod", "vinod@vinod.co", 4500.0, "Bangalore"),
				new Employee(2, "Anil", "anil@xmpl.com", 4200.0, "Chennai"),
				new Employee(3, "Ramesh", "ramesh@xmpl.com", 4800.0, "Bangalore"));
		when(em.getAll()).thenReturn(emps);
		when(em.getById(1)).thenReturn(new Employee(1, "Vinod", "vinod@vinod.co", 4500.0, "Bangalore"));

	}

	@Test
	void shouldGetListOfEmps() throws Exception {
		String url = "/api/employees";

		MvcResult r = mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk()).andReturn();

		String strResp = r.getResponse().getContentAsString();
		List<Employee> lst = om.readValue(strResp, List.class);
		Assertions.assertEquals(3, lst.size());

	}

	@Test
	void shouldGetOneEmployee() throws Exception {
		String url = "/api/employees/1";

		MvcResult r = mockMvc.perform(get(url)).andExpect(status().isOk()).andDo(print()).andReturn();

		String strResp = r.getResponse().getContentAsString();
		Employee e = om.readValue(strResp, Employee.class);
		Assertions.assertNotNull(e);
		Assertions.assertEquals("Vinod", e.getName());
		Assertions.assertEquals("vinod@vinod.co", e.getEmail());
		Assertions.assertEquals("Bangalore", e.getCity());
		Assertions.assertEquals(4500., e.getSalary());

	}

}
