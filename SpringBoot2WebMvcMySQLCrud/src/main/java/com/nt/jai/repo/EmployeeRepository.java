package com.nt.jai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.jai.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT COUNT(empMail) FROM Employee WHERE empMail=:empMail")
	Integer getEmployeeEmailCount(String empMail);

}
