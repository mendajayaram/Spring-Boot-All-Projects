package com.nt.jai.controleer;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.model.Student;

@RestController
@RequestMapping("/std")
public class StudentRestController {
	@GetMapping("/data")
	public ResponseEntity<String> showMsg() {
		return ResponseEntity.ok("Hello");
	}

	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		return ResponseEntity.ok("Student data is " + student);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		System.out.println("EXECUTED.........");
		return ResponseEntity.ok("Student data is " + student);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeStudent(@PathVariable Integer id) {
		return ResponseEntity.ok("Student removed " + id);
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable Integer id) {
		return ResponseEntity.ok(new Student(id, "TEST", 200.0));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent() {
		return ResponseEntity.ok(Arrays.asList(new Student(110, "SAM", 250.0), new Student(112, "SYED", 252.0),
				new Student(113, "RAM", 251.0)));
	}
}
