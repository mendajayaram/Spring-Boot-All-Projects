package com.nt.jai.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.jai.model.Book;
import com.nt.jai.repo.BookRepository;
@Component
public class MyDataRunner implements CommandLineRunner {
	@Autowired
	private BookRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Book(2505, "Spring Boot", "SAM", 500.0));
		repo.save(new Book(2506, "Microservices", "SYED", 600.0));
		repo.save(new Book(2507, "Angular 10.x", "RAM", 800.0));
		List<Book> list = repo.findAll();
		list.forEach(System.out::println);
	}
}
