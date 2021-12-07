package com.wei.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wei.mvc.models.Book;
import com.wei.mvc.services.BooksService;

@RestController
public class BooksApi {
	private final BooksService booksService;

	public BooksApi(BooksService booksService) {
		this.booksService = booksService;
	}
	
	
	@RequestMapping("/api/books")
	public List<Book> index() {
		return booksService.allBooks();
	}
	
	@PostMapping("/api/books")
	public Book create(
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="pages") Integer pages) {
		
		Book book = new Book(title, description, language, pages);
		return booksService.createBook(book);
	}
	
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = booksService.findBook(id);
		return book;
	}
	
	// @PutMapping
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = booksService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
 
    
    // @DeleteMapping
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	booksService.deleteBook(id);
    }
}
