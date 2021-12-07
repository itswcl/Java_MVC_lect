package com.wei.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wei.mvc.models.Book;

@Repository
											 // <Model Class, ID> from model
public interface BookRepository extends CrudRepository<Book, Long>{
	// query creation for JPA
	// retribute all the books from db
	List<Book> findAll();
	
	// retribute books by the title
	List<Book> findByTitleIs(String title);
	
	// finds the book contains the giving search string
	List<Book> findByDescriptionContaining(String search);
	
	// counts how many title we contain a certain string
	Long countByTitleContaining(String search);
	
	// delete books start from search
	Long deleteByTitleStartingWith(String search);
	
}

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords