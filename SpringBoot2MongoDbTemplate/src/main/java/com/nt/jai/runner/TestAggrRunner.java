package com.nt.jai.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.nt.jai.model.MyResult;
import com.nt.jai.model.Student;

@Component
public class TestAggrRunner implements CommandLineRunner {
	@Autowired
	private MongoTemplate mt;

	@Override
	public void run(String... args) throws Exception {

		Aggregation ag = Aggregation.newAggregation(Aggregation.match(Criteria.where("stdFee").gt(1.1)),

		Aggregation.sort(Direction.DESC, "stdName"), Aggregation.project("stdName"));
		// execute (aggregate, source, ResultClasstype)
		mt.aggregate(ag, Student.class, MyResult.class).forEach(System.out::println);

	}

}
