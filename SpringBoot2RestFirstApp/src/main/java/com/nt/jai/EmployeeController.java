package com.nt.jai;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@GetMapping("/Getdata")
	public ResponseEntity<String> shwdata(){
		 ResponseEntity<String>  resp= new ResponseEntity<String> ("Hello GET",HttpStatus.OK); 
		return resp;
		
	}
	@PostMapping("/Savedata")
	public ResponseEntity<String> savadata(){
		 ResponseEntity<String>  resp= new ResponseEntity<String> ("Hello POST",HttpStatus.OK); 
		return resp;
		
	}
	@PutMapping("/Updatedata")
	public ResponseEntity<String> modifydata(){
		 ResponseEntity<String>  resp= new ResponseEntity<String> ("Hello PUT",HttpStatus.OK); 
		return resp;
		
	}
	@DeleteMapping("/Deletedata")
	public ResponseEntity<String> delletedata(){
		 ResponseEntity<String>  resp= new ResponseEntity<String> ("Hello DELETE",HttpStatus.OK); 
		return resp;
		
	}
	@PatchMapping("/Patchdata")
	public ResponseEntity<String> modifybyemailbasedonid(){
		 ResponseEntity<String>  resp= new ResponseEntity<String> ("Hello PATCH",HttpStatus.OK); 
		return resp;
		
	}

}
