package com.wei.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wei.mvc.models.Book;
import com.wei.mvc.repositories.BookRepository;

@Service
public class BooksService {
	
// Dependency injection
	// add the book repo as dependency
	private final BookRepository bookRepository;
	
	public BooksService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// CRUD
	// READ all books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	
	// CREATE a book
	public Book createBook(Book newBook) {
		return bookRepository.save(newBook);
	}
	
	
	// READ a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	
	// UPDATE a book method 1
	// UPDATE book could be same as create
	public Book updateBook(
			Long id, String title, String desc, String lang, int numOfPages) {
		// use the function findBook(id)
		Book foundBook = findBook(id);
		
		if (foundBook != null) {
			
			foundBook.setTitle(title);
			foundBook.setDescription(desc);
			foundBook.setLanguage(lang);
			foundBook.setNumberOfPages(numOfPages);
			
			return bookRepository.save(foundBook);
			
		} else {
			
			return this.createBook(new Book(title, desc, lang, numOfPages));
		}
	}
	
//	UPDATE a book method 2 same as create method
//	public Book updateBook(Book book) {
//		return bookRepository.save(book);
//	}

	
	// DELETE a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
}
