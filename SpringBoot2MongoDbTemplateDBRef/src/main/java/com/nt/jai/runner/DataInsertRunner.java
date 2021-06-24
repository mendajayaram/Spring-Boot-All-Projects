package com.nt.jai.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.jai.model.Address;
import com.nt.jai.model.Department;
import com.nt.jai.model.Employee;
import com.nt.jai.repo.AddressRepository;
import com.nt.jai.repo.DeptRepository;
import com.nt.jai.repo.EmployeeRepository;

@Component
@Order(1)

public class DataInsertRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private AddressRepository arepo;
	@Autowired
	private DeptRepository derepo;

	@Override
	public void run(String... args) throws Exception {
		arepo.deleteAll();
		derepo.deleteAll();
		repo.deleteAll();
		Address addr = new Address(109, "8-9/A", "HYD", 500032L);
		arepo.save(addr);
		List<Department> dobs = List.of(new Department(11, "D1", "DEV-AB"), new Department(12, "D2", "QA-RB"),
				new Department(13, "D3", "SUPRT-MN"));

		derepo.saveAll(dobs);

		repo.save(new Employee(10, "SAM", 2000.0, Set.of("HTC", "NIT", "ORCL"),
				List.of("3.2GA", "6.5RELEASE", "0.1 ALPHA"), new String[] { "A+", "GR-T", "UI-NEW" },
				Map.of("C1", "TECN", "C2", "US-ARMY", "C3", "JANSON & JANSON"), addr, dobs));

	}

}
