package com.nt.jai.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.jai.model.Department;
import com.nt.jai.model.Employee;
import com.nt.jai.model.Project;
import com.nt.jai.repo.DepartmentRepository;
import com.nt.jai.repo.EmployeeRepository;
import com.nt.jai.repo.ProjectRepository;
@Component
public class MyDataInsertRunner implements CommandLineRunner {

	@Autowired
	private DepartmentRepository drepo;
	@Autowired
	private ProjectRepository prepo;
	@Autowired
	private EmployeeRepository erepo;

	public void run(String... args) throws Exception {
		Department d1 = new Department(101, "DEV", "SAM");
		Department d2 = new Department(102, "QA", "SYED");
		drepo.save(d1);
		drepo.save(d2);
		Project p1 = new Project(501, "P1", "HTC");
		Project p2 = new Project(502, "P2", "NIT");
		Project p3 = new Project(503, "P3", "XYZ");
		Project p4 = new Project(504, "P4", "ORCL");
		prepo.save(p1);
		prepo.save(p2);
		prepo.save(p3);
		prepo.save(p4);
		Employee e1 = new Employee(2021, "A", 500.0, d1, Arrays.asList(p1, p2));
		Employee e2 = new Employee(2022, "B", 600.0, d1, Arrays.asList(p2, p3));
		Employee e3 = new Employee(2023, "C", 700.0, d2, Arrays.asList(p3, p4));
		Employee e4 = new Employee(2024, "D", 800.0, d2, Arrays.asList(p3, p1));
		erepo.save(e1);
		erepo.save(e2);
		erepo.save(e3);
		erepo.save(e4);
	}
}