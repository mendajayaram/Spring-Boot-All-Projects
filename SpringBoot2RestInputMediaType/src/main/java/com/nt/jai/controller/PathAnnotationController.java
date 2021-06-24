package com.nt.jai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class PathAnnotationController {

	@GetMapping("/Showdata")
	public String ShowDataA(@RequestParam Integer pid,@RequestParam String pcode ,@RequestParam Double pcost) {
		return "Required Data is========>"+pid+" ,"+pcost+", "+pcode;
		
	}
	@GetMapping("/format/{pcode}")
	public String producttest(@PathVariable String  pcode) {
		return "Hello===>"+pcode;
		
	}
	
	  @GetMapping("/format/{pcost}") 
	  public String findDataB(@PathVariable Double pcost) 
	  { 
		  return "PATH DATA-B=>"+pcost; 
	  }
	  @GetMapping("/emp/mode/code")
	  public String showA() {
	  return "FROM#A";
	  }
	  @GetMapping("/emp/mode/{code}")
	  public String showB(
	  @PathVariable String code
	  ) 
	  {
	  return "FROM#B "+ code;
	  }
	  @GetMapping("/emp/{mode}/{code}")
	  public String showC(
	  @PathVariable String mode,
	  @PathVariable String code
	  ) 
	  {
	  return "FROM#C "+ mode +"," +code;
	  }
	  @GetMapping("/{emp}/{mode}/{code}")
	  public String showD(
	  @PathVariable String emp,
	  @PathVariable String mode,
	  @PathVariable String code
	  ) 
	  {
	  return "FROM#D " +emp +", "+ mode +"," +code;
	  }
	
}
