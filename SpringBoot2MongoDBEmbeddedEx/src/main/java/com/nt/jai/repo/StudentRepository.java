package com.nt.jai.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.jai.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}
