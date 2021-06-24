/*
 * package com.nt.jai.runner;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Component;
 * 
 * import com.nt.jai.model.Book; import com.nt.jai.repo.BookRepository;
 * 
 * //@Component public class MyDataRunner implements CommandLineRunner {
 * 
 * @Autowired private BookRepository repo;
 * 
 * @Override public void run(String... args) throws Exception {
 * repo.deleteAll(); repo.save(new Book(2505, "Spring Boot", "SAM", 500.0,
 * "BackEnd")); repo.save(new Book(2506, "Microservices", "SYED", 600.0,
 * "BackEnd")); repo.save(new Book(2507, "Angular 11", "RAM", 800.0,
 * "FrontEnd"));
 * 
 * }
 * 
 * }
 */