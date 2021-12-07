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
	
	
	// UPDATE a book
	// UPDATE book could be same as create
	public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
		// get the one book from db by giving id
		Optional<Book> optionalBook = bookRepository.findById(id);
		
		// if found the book
		if (optionalBook.isPresent()) {
			// get the book 
			Book target = optionalBook.get();
			
			// reset the book by required data
			target.setTitle(title);
			target.setDescription(desc);
			target.setLanguage(lang);
			target.setNumberOfPages(numOfPages);
			
			// save the new data book
			return bookRepository.save(target);
			
		} else {
			return this.createBook(new Book(title, desc, lang, numOfPages));
		}
	}
	

	
	// DELETE a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
}
