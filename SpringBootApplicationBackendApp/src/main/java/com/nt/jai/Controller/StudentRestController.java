package com.nt.jai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.exception.StudentNotFoundException;
import com.nt.jai.model.Student10;
import com.nt.jai.service.Studentimpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/rest/students")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "SAMPLE", description = "STUDENT OPERATIONS")
public class StudentRestController {
	@Autowired
	private Studentimpl studentser;

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student10 student) {
		ResponseEntity<String> resp = null;
		try {
			Integer id = studentser.savestudent(student);
			resp = new ResponseEntity<String>("Student '" + id + "' saved\"", HttpStatus.OK);
		} catch (StudentNotFoundException snf) {
			throw snf;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to Save Data", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}

	@PostMapping("/savedata")
	public Student10 saveStudent1(@RequestBody Student10 student) {
		ResponseEntity<Student10> resp = null;
		try {
			studentser.savestudent(student);
			resp = new ResponseEntity<Student10>(HttpStatus.OK);
		} catch (StudentNotFoundException snf) {
			throw snf;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<Student10>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return student;

	}

	@GetMapping("/All")
	public ResponseEntity<?> studentallreords() {
		ResponseEntity<?> resp = null;
		try {
			List<Student10> list = studentser.getallstuddents();
			resp = new ResponseEntity<List<Student10>>(list, HttpStatus.OK);
		} catch (StudentNotFoundException snf) {
			throw snf;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to Get Data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;

	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getStudentByid(@PathVariable Integer id) {
		ResponseEntity<?> resp = null;
		try {
			Student10 s = studentser.getonestudent(id);
			resp = new ResponseEntity<Student10>(s, HttpStatus.OK);
		} catch (StudentNotFoundException snf) {
			throw snf;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Student '" + id + "' Not Exist", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;

	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable Integer id) {
		ResponseEntity<String> resp = null;
		try {
			// Student10 s = studentser.getonestudent(id);
			studentser.deletestudent(id);
			resp = new ResponseEntity<String>("Student '" + id + "' Deleted", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable Delete the   Data", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}

	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody Student10 student) {
		ResponseEntity<String> resp = null;
		try {
			Student10 sid = studentser.getonestudent(id);
			sid.setSname(student.getSname());
			sid.setPhno(student.getPhno());
			sid.setSaddress(student.getSaddress());
			sid.setSbranch(student.getSbranch());
			sid.setSfee(student.getSfee());
			studentser.savestudent(sid);

			return new ResponseEntity<String>("Employee '" + id + "' Updated", HttpStatus.OK);
		} catch (StudentNotFoundException snf) {
			throw snf;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to Update Data", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}
}
