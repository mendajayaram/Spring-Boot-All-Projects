package com.nt.jai.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.jai.exception.EmployeeNotFoundException;
import com.nt.jai.model.Employee;
import com.nt.jai.repo.EmployeeRepository;
import com.nt.jai.util.EmployeeUtil;
@Service
public class EmployeeImp implements IEmployeeService {
@Autowired
	private EmployeeRepository erpo;
	@Autowired
      private EmployeeUtil util;

	@Override
	public Integer savaemployee(Employee e) {
		util.calculateDetails(e);
		Integer id=erpo.save(e).getEmpId();
		return id;
	}
	

	@Override
	public List<Employee> getallemployee() {
	
		return erpo.findAll();
	}
	@Override
	public Employee getOneEmployee(Integer id) {
	
		Optional<Employee>opt=erpo.findById(id);
				if(opt.isPresent()) {
					return	opt.get();
				}
		
				else {
					 throw new EmployeeNotFoundException( "Employee '"+id+"' Not exist");
							}

				
	}
	@Override
	public void updateemployee(Employee e) {
		getOneEmployee(e.getEmpId());
		util.calculateDetails(e);
		erpo.save(e);
		
	}

	@Override
	public void deleteEmployee(Integer id) {
		
		erpo.delete(getOneEmployee(id));
		
	}

	

	@Override
	@Transactional
	public Integer updateEmployeeMail(Integer id, String email) {
	
		return erpo.updateEmployeeMail(id, email);
	}

	

}
