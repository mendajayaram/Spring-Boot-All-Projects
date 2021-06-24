package com.nt.jai.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.nt.jai.model.Employee;
@Component
@Order(2)
public class DataFetchRunner implements CommandLineRunner {
	@Autowired
	private MongoTemplate mt;

	@Override
	public void run(String... args) throws Exception {
		Aggregation aggr = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(10)),
				Aggregation.sort(Direction.DESC, "empName"), Aggregation.project("empName","empSal","empPrjs","empPrjVer","empGrades","empClient", "addr", "dobs"));
		List<Employee> list = mt.aggregate(aggr, "employee", Employee.class).getMappedResults();
		list.forEach(System.out::println);

	}

}
