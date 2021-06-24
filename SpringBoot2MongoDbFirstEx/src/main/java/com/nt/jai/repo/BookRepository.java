package com.nt.jai.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.jai.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
