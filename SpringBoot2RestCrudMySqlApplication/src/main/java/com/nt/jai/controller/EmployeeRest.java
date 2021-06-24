package com.nt.jai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.exception.EmployeeNotFoundException;
import com.nt.jai.model.Employee;
import com.nt.jai.service.EmployeeImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/employee")
@Api(value = "SAMPLE", description = "EMPLOYEE OPERATIONS")

public class EmployeeRest {
	@Autowired
	private EmployeeImp service;

	@ApiOperation("EmployeeInsertData")
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Employee employee) {

		ResponseEntity<String> resp = null;

		try {
			Integer id = service.savaemployee(employee);
			resp = new ResponseEntity<String>("Employee saved " + id, HttpStatus.CREATED);

		
	} catch(EmployeeNotFoundException enfe) {
		//re-throw back to handler
		throw enfe;
	}

		catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to process save", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}
	@ApiOperation("EmployeeInsertDataCreate")
	@PostMapping("/create")
	public Employee create(@RequestBody Employee employee) {

		ResponseEntity<String> resp = null;

		try {
			Integer id = service.savaemployee(employee);
			resp = new ResponseEntity<String>("Employee saved " + id, HttpStatus.CREATED);

		
	} catch(EmployeeNotFoundException enfe) {
		//re-throw back to handler
		throw enfe;
	}

		catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to process save", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return employee;
	}

	@ApiOperation("FetchEmployeeofdata")
	@GetMapping("/All")
	public ResponseEntity<?> getalldata() {
		ResponseEntity<?> resp = null;
		try {
			List<Employee> list = service.getallemployee();
			if(list!=null && list.isEmpty()) {
			resp = new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		} 
		else {
			resp = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		}
		}
		catch(EmployeeNotFoundException enfe) {
			//re-throw back to handler
			throw enfe;
		}catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to fetch data", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}

	@ApiOperation("FetchEmployeeofdatabasedonid")
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getoneid(@PathVariable Integer id) {
		ResponseEntity<?> resp = null;
		try {
			Employee employee = service.getOneEmployee(id);
			resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (EmployeeNotFoundException enf) {
			throw enf;
			
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to fetch data", HttpStatus.INTERNAL_SERVER_ERROR);
			// e.MyCustomExceptionHandler
		}

		return resp;

	}

	@ApiOperation("DeleteEmployeeofdatabasedonid")
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeemployye(@PathVariable Integer id) {
		ResponseEntity<String> resp = null;

		try {
			service.deleteEmployee(id);
			resp = new ResponseEntity<String>("Employee deleted!" + id, HttpStatus.OK);
		} catch (EmployeeNotFoundException enf) {
			throw enf;
			
		
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to deleted data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;

	}

	@ApiOperation("UpdateEmployeeofdatabasedonid")
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee,@PathVariable Integer id) {
		ResponseEntity<String> resp = null;
		try {
			service.updateemployee(employee);
			resp = new ResponseEntity<String>("Employee Updated!", HttpStatus.OK
			// HttpStatus.RESET_CONTENT
			);
		} catch (EmployeeNotFoundException enf) {
			throw enf;
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to update data", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}
	
	

	@ApiOperation("UpdateEmployeemailofdatabasedonid")
	@PatchMapping("/modify/{id}/{email}")
	public ResponseEntity<String> updateEmail(@PathVariable Integer id, @PathVariable String email) {
		ResponseEntity<String> resp = null;
		try {
			String msg = null;
			Integer count = service.updateEmployeeMail(id, email);
			if (count > 0)
				msg = "Email Updated!";
			else
				msg = "Email not Updated!";

			resp = ResponseEntity.ok(msg);
		}catch (EmployeeNotFoundException enf) {
			throw enf;
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Unable to update email", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

}
