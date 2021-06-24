package com.nt.jai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
@GetMapping("/showdata")
	public ResponseEntity<String> Showdataa(){
		String body = "Welcome to Simple data";

		return new ResponseEntity<String>(body,HttpStatus.OK) ;
		
	}
@GetMapping("/obj")
public ResponseEntity<Employee> ShowdataB(){
	Employee e=new Employee(10,"jayaram",50000.00);
	return new ResponseEntity<>(e,HttpStatus.OK);
	
}
@GetMapping("/obja")
public Employee Showc() {
	Employee e=new Employee(1,"jai",70000.00);
	return e;
	
}
}
