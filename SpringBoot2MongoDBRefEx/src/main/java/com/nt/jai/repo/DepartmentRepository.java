package com.nt.jai.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.jai.model.Department;

public interface DepartmentRepository extends MongoRepository<Department, Integer> {

}
