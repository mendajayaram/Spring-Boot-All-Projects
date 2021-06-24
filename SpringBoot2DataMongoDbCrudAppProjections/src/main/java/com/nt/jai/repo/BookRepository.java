package com.nt.jai.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.jai.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

	//SQL: select bookName,bookAuthor from book where bid>?
	@Query(value="{bookId :{ $gte:?0}}",fields="{bookName:1},{bookAuthor:1}")
	List<String> getAllBooksById(Integer bookId);
	//List<Book> getAllBooksById(Integer bookId);
//********************************************************************************************	
	//SQL: select bookAuthor from Book where bookType=?
	@Query(value="{bookType : ?0}" , fields="{bookAuthor:1,_id:0}")
	List<String> getBooksDataA(String bookType);
//********************************************************************************************	
	//SELECT * FROM BOOK WHERE bookAuthor like ?
	@Query("{bookAuthor : {regex:?0}}")
	List<Book> getBooksByAuthor(String input);
//********************************************************************************************	
	//SELECT * FROM BOOK WHERE bookId In (....)
	
@Query("{ bookId :{ $in : ?0 } }")
List<Book> getBooksByIds(List<Integer> ids);

//********************************************************************************************
//SELECT * FROM BOOK WHERE bookId between ?1 and ?2
@Query("{ bookId : { $gt : ?0 , $lt: ?1 } }")
List<Book> getBooksByIdsBetween(Integer id1,Integer id2);
//********************************************************************************************
//SELECT * FROM BOOK WHERE bookId >? order by bookType
	@Query(value="{bookId: {$gt : ?0} }",sort= "{bookType :1}")
	List<Book> getBooksInOrder(Integer id);
	//********************************************************************************************

	@Query(value="{bookId: {$gt : ?0} }",sort= "{bookType :-1}")
	List<Book> getBooksUnOrder(Integer id);
	//********************************************************************************************

	//SELECT count(*) FROM BOOK WHERE bookId >?
	@Query(value = "{ bookId : { $gt : ?0} }", count = true)
	Integer getBooksCount(Integer id);

	
}
