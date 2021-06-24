package com.nt.jai.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.jai.model.Employee;

public interface EmployeeRepository 
extends MongoRepository<Employee, Integer> {
}
