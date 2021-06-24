package com.nt.jai.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.jai.model.Book;
import com.nt.jai.repo.BookRepository;

@Component
public class TestQueryRunner implements CommandLineRunner {
	@Autowired
	private BookRepository repo;

	public void run(String... args) throws Exception {

		Optional<Book> opt = repo.getBookById(1505);
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			System.out.println("No Data Found");
		}

		
		repo.getBooksByWriterAndCategory("SAM", "BackEnd");

		repo.getBooksByNoOfPages(150).filter(ob -> ob.getCategory().equals("BackEnd"))
				.sorted((ob1, ob2) -> ob1.getId().compareTo(ob2.getId()))
				.map(ob -> ob.getTitle() + " is written by :" + ob.getWriter()).forEach(System.out::println);

		repo.getBooksByWriterAndNoPages("SAM", 900);
		repo.getBooksByWriterAndCategory("SAM", "BackEnd");
		repo.getBooksByWriterOrCategory("SAM", "FrontEnd");
		repo.getBooksByDataA(5, "SAM", "FrontEnd").forEach(System.out::println);
	}
}