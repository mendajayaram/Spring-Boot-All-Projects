package com.nt.jai.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.jai.model.Address;
import com.nt.jai.model.Department;
import com.nt.jai.model.Employee;
import com.nt.jai.repo.AddressRepository;
import com.nt.jai.repo.DepartmentRepository;
import com.nt.jai.repo.EmployeeRepository;

@Component

public class DataInsertRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private DepartmentRepository drepo;

	@Autowired
	private AddressRepository arepo;

	@Override
	public void run(String... args) throws Exception {

		Department d1 = new Department(100, "d-101", "ENg");
		Department d2 = new Department(101, "d-102", "ENg");
		Department d3 = new Department(102, "d-103", "ENg");
		Department d4 = new Department(103, "d-104", "ENg");
		drepo.save(d1);
		drepo.save(d2);
		drepo.save(d3);
		drepo.save(d4);

		Address a = new Address(1, "c289", "Kesaripada", 532291);
		Address a1 = new Address(2, "c64", "Kanchili", 532290);
		Address a2 = new Address(3, "c58", "Srikakulam", 532292);
		Address a3 = new Address(4, "c70", "sompeta", 532293);

		arepo.save(a);
		arepo.save(a1);
		arepo.save(a2);
		arepo.save(a3);

		repo.save(new Employee(10, "Jayaram", 500.0, Set.of("HTC", "NIT", "ORCL"),
				List.of("3.2GA", "6.5RELEASE", "0.1 ALPHA"), new String[] { "A+", "GR-T", "UI-NEW" },
				Map.of("C1", "TEC-N", "C2", "US-ARMY", "C3", "JANSON & JANSON"), a, List.of(d1)));
		repo.save(new Employee(11, "Jayaram", 500.0, Set.of("HTC", "NIT", "ORCL"),
				List.of("3.2GA", "6.5RELEASE", "0.1 ALPHA"), new String[] { "A+", "GR-T", "UI-NEW" },
				Map.of("C1", "TEC-N", "C2", "US-ARMY", "C3", "JANSON & JANSON"), a1, List.of(d2)));
		repo.save(new Employee(12, "Jayaram", 500.0, Set.of("HTC", "NIT", "ORCL"),
				List.of("3.2GA", "6.5RELEASE", "0.1 ALPHA"), new String[] { "A+", "GR-T", "UI-NEW" },
				Map.of("C1", "TEC-N", "C2", "US-ARMY", "C3", "JANSON & JANSON"), a2, List.of(d3)));
		repo.save(new Employee(13, "Jayaram", 500.0, Set.of("HTC", "NIT", "ORCL"),
				List.of("3.2GA", "6.5RELEASE", "0.1 ALPHA"), new String[] { "A+", "GR-T", "UI-NEW" },
				Map.of("C1", "TEC-N", "C2", "US-ARMY", "C3", "JANSON & JANSON"), a3, List.of(d4)));

	}

}
