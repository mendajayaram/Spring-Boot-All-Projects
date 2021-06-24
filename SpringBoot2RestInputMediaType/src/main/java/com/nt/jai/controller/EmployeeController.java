package com.nt.jai.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@GetMapping("/backup")
	public ResponseEntity<Void> exportDataAsBack(){
		System.out.println("EXECUTING BACKUP PROCESS");
		return new ResponseEntity<Void>
		(HttpStatus.NO_CONTENT);

	}
	
	@PostMapping("/save")
	public ResponseEntity<String>savadata(){
		return new ResponseEntity<String>("Employee created!",HttpStatus.CREATED);
		
	}
	
	@PostMapping("/read")
	public ResponseEntity<Employee> read(@RequestBody Employee employee){
		
		var sal=employee.getEsal();
		var hra=sal*12/100;
		var ta=sal*3/100;
		
		employee.setHra(hra);
		employee.setTa(ta);
		
		
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
		
	
		
	}
	@GetMapping("/data")
	public ResponseEntity<String> processData() {
	if(new Random().nextInt(100)<=100)
	{
	throw new RuntimeException("DUMMY");
	}
	return null;
	}

}
