package com.nt.jai.service;

import java.util.List;


import com.nt.jai.model.Employee;

public interface IEmployeeService {

	
	public Integer savaemployee(Employee e);
	
	public List<Employee> getallemployee();
	
	public void updateemployee(Employee e);
	
	public void deleteEmployee(Integer id);
	
	public Employee getOneEmployee(Integer id);
	
	public Integer updateEmployeeMail(Integer id,String email);
	
}
