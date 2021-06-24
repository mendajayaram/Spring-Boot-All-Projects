package com.nt.jai.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nt.jai.exception.EmployeeNotFoundException;

public class MyCustomExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException enfe) {
		return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);
	}
}
