package com.nt.jai.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.model.StdCourse;
import com.nt.jai.model.Student;

@RestController
@RequestMapping("/Student")
public class StudentController {
@GetMapping("/StudentDetails")
	public ResponseEntity<Student> showdata(){
		//Student s=new Student(10,"jayaram",Set.of("Eng","Maths","Science","Hindi"),Map.of("eng","A+","Maths","A+","Science","A+","Hindi","A+"),new StdCourse(10,"raja",3500.00));
		Student s=new Student(10,"Jayaram",Set.of("Eng","Maths","Science","Hindi"),Arrays.asList(80,90,100),Map.of("eng","A+","Maths","A+","Science","A+","Hindi","A+"),new StdCourse(10,"Java",5699.00));
		return new ResponseEntity<Student>(s,HttpStatus.OK);
		
	}
}
