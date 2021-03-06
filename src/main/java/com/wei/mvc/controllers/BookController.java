package com.wei.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wei.mvc.models.Book;
import com.wei.mvc.services.BooksService;

@Controller
public class BookController {

	@Autowired
	BooksService booksService;

	public BookController(BooksService booksService) {
		this.booksService = booksService;
	}

	@GetMapping("/")
	public String redirectToBooks() {
		return "redirect:/books";
	}

	@GetMapping("/books")
	public String allBooks(Model model) {
		List<Book> books = booksService.allBooks();

		model.addAttribute("books", books);
		// WEB-INF/books/index.jsp path
		return "/books/index.jsp";
	}

	@GetMapping("/books/{bookId}")
	public String index(
			// path variable to link the url id giving
			@PathVariable("bookId") Long bookId, Model model) {
		Book book = booksService.findBook(bookId);

		model.addAttribute("book", book);

		return "/books/show.jsp";
	}

	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}

	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/new.jsp";
		} else {
			booksService.createBook(book);
			return "redirect:/books";
		}
	}

	@GetMapping("/books/{bookId}/edit")
	public String editRoute(@PathVariable("bookId") Long bookId, Model model) {
		Book book = booksService.findBook(bookId);
		model.addAttribute("book", book);
		return "/books/edit.jsp";
	}

	@PutMapping("/books/{bookId}")
	public String editRequest(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			@PathVariable("bookId") Long bookId,
			@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="numberOfPages") Integer numOfPages) {
	
		if(result.hasErrors()) {
			return "/books/edit.jsp";
		} else {

			booksService.updateBook(bookId, title, desc, lang, numOfPages);
			return "redirect:/books";
		}
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable("bookId") Long bookId) {
		booksService.deleteBook(bookId);
		return "redirect:/books";
	}
	

}
