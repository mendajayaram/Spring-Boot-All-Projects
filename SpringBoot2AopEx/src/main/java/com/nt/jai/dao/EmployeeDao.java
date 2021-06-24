package com.nt.jai.dao;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	public String saveEmployee() {
		System.out.println("FROM SAVE EMPLOYEE");
		/*if(new Random().nextInt(15)<=10) {
			throw new RuntimeException("DUMMY EXCEPTION");
		}*/
		return "HELLO";
	}
}
