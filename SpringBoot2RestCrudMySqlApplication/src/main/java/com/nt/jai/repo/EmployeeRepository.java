package com.nt.jai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.jai.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	@Modifying
	@Query("UPDATE Employee SET empMail=:email WHERE empId=:id")
	public Integer updateEmployeeMail(Integer id,String email);

}
