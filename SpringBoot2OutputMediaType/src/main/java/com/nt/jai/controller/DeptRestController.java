package com.nt.jai.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.model.CompanyInfo;
import com.nt.jai.model.Dept;
import com.nt.jai.model.Employee;

@RestController
@RequestMapping("Dept")
public class DeptRestController {
	@GetMapping("/obja")

	public ResponseEntity<Dept> showdata(){
		Dept body = new Dept(1440, "DEVELOPMENT", "DEV", 
				Arrays.asList(
				new Employee(101, "A",30.0),
				new Employee(102, "B",31.0),
				new Employee(103, "C",32.0),
				new Employee(104, "D",33.0)),
				new CompanyInfo(150, "NIT HYD"));
				return new ResponseEntity<Dept>(body, HttpStatus.OK);

	}
}
