package com.nt.jai.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.model.Employee;

@RestController
@RequestMapping("/Employee")
public class EmployeeRestController {
	@GetMapping("/obja")
	public ResponseEntity<Employee> ShowDataA(){
		Employee e=new Employee(10,"jayaram",12345678.00);
		return new  ResponseEntity<Employee>(e,HttpStatus.OK);
		
	}
	
	@GetMapping("/objb")
	public ResponseEntity<List<Employee>> ShowDataA1(){
		List<Employee> e= Arrays.asList(new Employee(101, "A", 30.0),
				new Employee(102, "B", 31.0),
				new Employee(103, "C", 32.0),
				new Employee(104, "D", 33.0));
				
		return new  ResponseEntity<List<Employee>>(e,HttpStatus.OK);
		
	}
	@GetMapping("/objc")
	public ResponseEntity<List<String>> showDataE() {
	List<String> body = Arrays.asList("ONE","TWO","ABC");
	return new ResponseEntity<List<String>>(body,
	HttpStatus.OK);
	}
}
