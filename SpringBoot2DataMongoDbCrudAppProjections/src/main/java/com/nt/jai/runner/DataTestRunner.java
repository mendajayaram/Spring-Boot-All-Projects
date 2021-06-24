package com.nt.jai.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.jai.repo.BookRepository;

@Component
public class DataTestRunner implements CommandLineRunner {
	@Autowired
	private BookRepository repo;

	public void run(String... args) throws Exception {
		// repo.getAllBooksById(100);
		repo.getBooksDataA("BackEnd").forEach(System.out::println);
		repo.getBooksByAuthor("^S").forEach(System.out::println); //starting with<input>
		repo.getBooksByAuthor("M$").forEach(System.out::println); //ending with <input>$
	    repo.getBooksByAuthor("A").forEach(System.out::println);//Containing <input>
		 repo.getBooksByIds(Arrays.asList(2505,2507,33,44,55)).forEach(System.out::println); //in operator
		 repo.getBooksByIdsBetween(2500, 2900).forEach(System.out::println);
		 repo.getBooksInOrder(2500) .forEach(System.out::println);
		 Integer count = repo.getBooksCount(2500);
		//Long count1 = repo.deleteBooksById(2500);
		System.out.println(count);
	}

}
