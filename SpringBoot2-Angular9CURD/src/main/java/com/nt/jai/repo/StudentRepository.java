package com.nt.jai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.jai.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>
 {

}
