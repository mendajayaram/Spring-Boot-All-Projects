package com.nt.jai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.Services.StudentserviceImp;
import com.nt.jai.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentserviceImp stdservice;

	@PostMapping("/studentsave")
		
	public ResponseEntity<Student>String(@RequestBody Student student){
		System.out.println("Student===="+student);
		int i=stdservice.SavaStudent(student);
		System.out.println("Students=================="+i);
		
	
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	
}
