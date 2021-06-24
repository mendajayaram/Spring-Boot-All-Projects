package com.nt.jai.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nt.jai.exception.StudentNotFoundException;

public class CustomExceptionHandler {
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException enfe)
	{
		
		return new ResponseEntity<String>(enfe.getMessage(),	HttpStatus.NOT_FOUND);
	}
}
