package com.nt.jai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.jai.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeConteroller {
	@GetMapping("/edit")
	public String showEditPage(Model model) {
		Employee e = new Employee();
		e.setEid(10);
		e.setEname("Jayaram");
		e.setEmpgen("Male");
		e.setEsal(500000.00);
		e.setEmpproj("11");
		e.setEmpAddr("Kesaripada");
		e.setEmpLangs(List.of("ENG","SPN"));
		// DropDown Data (comes from DB)
		Map<Integer, String> myprjs = Map.of(10, "P1", 11, "P2", 12, "P3", 13, "P4", 14, "P5");
		model.addAttribute("myprjs", myprjs);
		model.addAttribute("employee", e);
		System.out.println("Employee Data:"+e);
		return "EmployeeEdit";
	}

	@PostMapping("/Update")
	public String doUpdate(@ModelAttribute Employee employee, Model model) {

		model.addAttribute("emp", employee);
		System.out.println("Employee Data:"+employee);
		return "EmployeeUpdate";
	}

}
