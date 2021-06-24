package com.nt.jai.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.jai.model.Book;
import com.nt.jai.model.MyIdGen;
import com.nt.jai.repo.BookRepository;

@Component
public class BookTestRunner implements CommandLineRunner {
	@Autowired
	private BookRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		// 1. save() - insert/update
		repo.save(new Book(MyIdGen.getId(), "Core Java", 500.0));
		repo.save(new Book(MyIdGen.getId(), "Adv Java", 600.0));
		Book b = repo.save(new Book(MyIdGen.getId(), "SpringBoot", 800.0));
		System.out.println(b.getId());
		
		repo.saveAll(Arrays.asList(new Book(MyIdGen.getId(), "Angular", 600.0), new Book(MyIdGen.getId(), "MS", 800.0),
				new Book(MyIdGen.getId(), "HTML", 900.0)));
		System.out.println("-----------DONE-------");

	}

}
