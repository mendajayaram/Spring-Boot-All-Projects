package com.nt.jai.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.jai.model.Book;
import com.nt.jai.repo.BookRepository;
@Component
public class DataInsertRunner implements CommandLineRunner {
	@Autowired
	private BookRepository repo;

	public void run(String... args) throws Exception {
		repo.deleteAll();
		repo.save(new Book(10, "Core Java", 250, "SAM", "BackEnd"));
		repo.save(new Book(11, "Adv Java", 260, "SYED", "BackEnd"));
		repo.save(new Book(12, "Angular", 350, "SAM", "FrontEnd"));
		repo.save(new Book(13, "HTML", 120, "SYED", "FrontEnd"));
		repo.save(new Book(14, "Spring Boot", 850, "SYED", "BackEnd"));
		repo.save(new Book(15, "Microservices", 350, "SAM", "BackEnd"));
		repo.save(new Book(16, "ReactJS", 180, "RAM", "FrontEnd"));
	}
}