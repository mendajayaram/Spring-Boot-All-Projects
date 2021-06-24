package com.nt.jai.controller;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.jai.exception.EmployeeNotFoundException;
import com.nt.jai.exception.NotImplementedException;
import com.nt.jai.exception.UserNotFoundException;
import com.nt.jai.model.Employee;

@Controller
public class EmployeeController {
	@GetMapping("/showa")
	//@RequestMapping(value = "/Showa")
	public String ShowA() {
		if (new Random().nextInt(10) <= 10)
			throw new RuntimeException("SAMPLE");
		return "Welcome";

	}

	@GetMapping("/showb")
	public String showB() {
		if (new Random().nextInt(10) <= 10)
			throw new NotImplementedException("SAMPLE");
		return "Welcome";
	}

	@GetMapping("/showc")
	public String showC() {
		if (new Random().nextInt(10) <= 10)
			throw new UserNotFoundException("SAMPLE");
		return "Welcome";
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getOneEmployee(
			@PathVariable Integer id)
	{
		if(id!=5)
			throw new EmployeeNotFoundException("EMPLOYEE NOT EXIST " + id);
		
		return ResponseEntity.ok(new Employee(id,"SAM"));
	}

}
