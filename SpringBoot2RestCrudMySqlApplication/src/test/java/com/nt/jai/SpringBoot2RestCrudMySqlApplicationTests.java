
package com.nt.jai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")

public class SpringBoot2RestCrudMySqlApplicationTests {

	@Autowired
	private MockMvc mockmvc;

	@Test
	@DisplayName("EMPLOYEE SAVE")
	@Order(1)

	
	
	public void testSaveEmployee() throws Exception {
		// 1. request object
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/employee/save")
				.contentType("application/json")
				.content("{\"empName\":\"ABCDEFGH\",\"empMail\":\"abcd@gmail.com\",\"empSal\":	20000.0}");
		// 2. execute and get result
		MvcResult result = mockmvc.perform(request).andReturn();
		// 3. read response
		MockHttpServletResponse response = result.getResponse();
		// 4. validate(assert) response
		// details
		assertEquals(HttpStatus.CREATED.value(),response.getStatus());
		if (!response.getContentAsString().contains("Employeesaved")) {
			fail("Employee not created");
		}

	}

	@Test
	@DisplayName("FETCH ONE EMPLOYEE")
	@Order(2)

	public void testGetOneEmployee() throws Exception {
		// 1. request creation
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/employee/find/6");
		// 2. execute and get result
		MvcResult result = mockmvc.perform(request).andReturn();
		// 3. read response
		MockHttpServletResponse response = result.getResponse();
		// 4. validate data
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
	}

	@Test
	@DisplayName("FETCH ONE EMPLOYEE NOT FOUND")
	@Order(3)

	public void testGetOneEmployeeNotExist() throws Exception {
		// 1. request creation
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/employee/find/6");
		
		// 2. execute and get result
		MvcResult result = mockmvc.perform(request).andReturn();
		// 3. read response
		MockHttpServletResponse response = result.getResponse();
		// 4. validate data
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		if (!response.getContentAsString().contains("Notexist")) {
			fail("Employee Exist! Check it once!!");
		}
	}

	@Test
	@DisplayName("FETCH ALL EMPLOYEES")
	@Order(4)

	public void testAllEmployees() throws Exception {
		// 1. request creation
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/employee/All");
		// 2. execute and get result
		MvcResult result = mockmvc.perform(request).andReturn();
		// 3. read response
		MockHttpServletResponse response = result.getResponse();
		// 4. validate data
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
		System.out.println(response.getContentAsString());
	}

	@Test
	@DisplayName("Update   EMPLOYEE BY ID")
	@Order(6)
	public void testupdateop() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/employee/update")
				.contentType("application/json")
				.content("{\"empId\":1,\"empName\":\"A\",\"empSal\":2500.0,\"empMail\":\"a@gm.com\"}");

		MvcResult result = mockmvc.perform(request).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		if (!response.getContentAsString().contains("EmployeeId Not Exit")) {
			fail("Unable to Update");
		}
	}

	@Test
	@DisplayName("REMOVE ONE EMPLOYEE BY ID")
	@Order(5)
	public void testRemoveOneEmployee() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/employee/remove/6");
		// 2. execute and get result
		MvcResult result = mockmvc.perform(request).andReturn();
		// 3. read response
		MockHttpServletResponse response = result.getResponse();
		// 4. validate
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		if (!response.getContentAsString().contains("Employeedeleted")) {
			fail("Unable to Delete");
		}
	}

	@Test
	@DisplayName("Update   EMPLOYEEmail BY ID")
	@Order(6)
	public void testupdateempmailop() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.patch("/modify/{id}/{email}")
				.contentType("application/json")
				.content("{\"empId\":1,\"empName\":\"A\",\"empSal\":2500.0,\"empMail\":\"a@gm.com\"}");

		MvcResult result = mockmvc.perform(request).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		if (!response.getContentAsString().contains("EmployeeId Not Exit")) {
			fail("Unable to Update");
		}
	}
}
