package com.nt.jai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.model.StdCourse;

@RestController
@RequestMapping("/course")
public class CourseController {
	@GetMapping("/obja")
	public ResponseEntity<StdCourse> showdata(){
		StdCourse c=new StdCourse(10,"java",35000.00);
		return new ResponseEntity<StdCourse>(c,HttpStatus.OK);
		
	}

}
