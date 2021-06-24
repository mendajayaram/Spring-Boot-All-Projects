package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/product")
public class EmployeeController {
	@GetMapping("/info")
	public String showInfo(Model model) {
	model.addAttribute("pid", 96960);
	model.addAttribute("pcode", "PEN");
	return "Products";
	}
	@GetMapping("/data")
	public String showData() {
	return "DataPage";
	}

}
