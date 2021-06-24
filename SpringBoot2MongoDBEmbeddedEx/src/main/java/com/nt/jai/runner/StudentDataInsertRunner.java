package com.nt.jai.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.nt.jai.model.Address;
import com.nt.jai.model.Student;
import com.nt.jai.model.Subject;
import com.nt.jai.repo.StudentRepository;

public class StudentDataInsertRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		repo.save(new Student(101, "SAM", 300.0, new Address("8-96/A", "CHN"),
				Arrays.asList(new Subject("ENG", 98), new Subject("MAT", 99), new Subject("SCI", 100))));

	}

}
