package com.nt.jai.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.nt.jai.model.Student;

//@Component

public class TestTemplateRunner implements CommandLineRunner {

	@Autowired
	private MongoTemplate mt;

	@Override
	public void run(String... args) throws Exception {
		// 1. save (insert/update)
		// mt.save(new Student(10, "A", 3.3));

		mt.save(new Student(10, "Jayaram", 3.3));
		mt.save(new Student(11, "Aadi", 4.3));
		mt.save(new Student(12, "Surabhi", 5.3));

		// fetch data and print
		List<Student> list = mt.findAll(Student.class);
		list.forEach(System.out::println);

		// 3. conditional based (Query) update/fetch/delete

		Query q = new Query();
		q.addCriteria(Criteria.where("stdName").is("Jayaram"));
		// a. fetch data
		mt.find(q, Student.class).forEach(System.out::println);

		// b. update data

		Update u = new Update();

		u.set("stdFee", 9.9);
		u.set("stdName", "SriramChandra");
		mt.findAndModify(q, u, Student.class);
		// c. remove data
		mt.findAndRemove(q, Student.class);
		System.out.println("DONE");

	}

}
