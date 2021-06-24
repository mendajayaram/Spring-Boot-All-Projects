package com.nt.jai.util;

import org.springframework.stereotype.Component;

import com.nt.jai.model.Employee;

@Component
public class EmployeeUtil {

	public void calculateDetails(Employee e) {
		var sal = e.getEmpSal();
		e.setEmpHra(sal*12/100.0);
		e.setEmpTa(sal*3/100.0);
	}
}
