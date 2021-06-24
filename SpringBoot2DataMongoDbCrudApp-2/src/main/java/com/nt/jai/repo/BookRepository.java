package com.nt.jai.repo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.jai.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {
	//custom query methods
	//SQL: select * from book where id=?
	@Query("{ id : ?0 }")
	//Book getBookById(Integer id);
	Optional<Book>  getBookById(Integer id);
	//SQL: select * from book where writer=? and category=?
	@Query("{$and : [ {writer : ?0 } , {category : ?1 } ]}")
	List<Book>getBooksByWriterAndCategory(String writer,String category  );
	
	//SQL: select * from book where noOfPages>=?
	@Query("{noOfPages:{$gte : ?0}}")
	//List<Book> getBooksByNoOfPages(Integer noOfPages);
	Stream<Book> getBooksByNoOfPages(Integer noOfPages);
	
	@Query("{ writer : ?0 , noOfPages : { $lt : ?1 } }")
	List<Book> getBooksByWriterAndNoPages(String writer,Integer noOfPages);

	//SQL: select * from book where writer=? or category=?
	@Query("{ $or : [ { writer : ?0} , {category : ?1} ] }")
	List<Book> getBooksByWriterOrCategory(String writer, String category);
	
	
	//SQL: select * from book where id>? and (writer=? or category=?)
	@Query("{ $and : [ { id : { $gt : ?0 } }, { $or : [ { writer :?1} , {category : ?2} ] } ] }")
	List<Book> getBooksByDataA(Integer id,String writer, String category);

	
	
	
}
