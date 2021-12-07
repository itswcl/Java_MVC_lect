package com.wei.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wei.mvc.models.Book;
import com.wei.mvc.services.BooksService;

@Controller
public class BookController {
	
	@Autowired
	BooksService booksService;
	
	public BookController(BooksService booksService) {
		this.booksService = booksService;
	}
	
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = booksService.allBooks();

		model.addAttribute("books", books);
		return "/index.jsp";
	}
	
	@GetMapping("/books/{bookId}")
	public String index(
			// path variable to link the url id giving
			@PathVariable("bookId") Long bookId,
			Model model) {
//		System.out.println(bookId);
		
		Book book = booksService.findBook(bookId);
				
//		System.out.println(book);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
}
