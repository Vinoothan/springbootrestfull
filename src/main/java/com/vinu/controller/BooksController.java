package com.vinu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinu.model.Books;
import com.vinu.service.BooksService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
public class BooksController {

	@Autowired
	BooksService booksService;

	@RequestMapping("/books")
	public Map getAllBooks() {
		Map map = booksService.getAllBooks();
		return map;

	}

	@RequestMapping("/books/{booknum}")
	public String getbookbyId(@PathVariable("booknum") int bookid) {
		System.out.println(bookid);
		System.out.println(booksService.hashCode());
		String bookName = booksService.getbooksbyId(bookid);
		return bookName;
	}

	@RequestMapping(value = "/books/{booknum}", method = RequestMethod.DELETE)
	public String deletebooksbyId(@PathVariable("booknum") int bookid) {
		// String msg = booksService.deletebooksbyId(bookid);
		return booksService.deletebooksbyId(bookid);
	}

	@PutMapping(value = "/books/{booknum}/{bookName}")
	public String updateBookDetails(@PathVariable int booknum, @PathVariable String bookName) {
		return booksService.updateBookDetails(booknum, bookName);
	}

	@PostMapping("/books")
	public String addBooksDetails(@RequestBody Books books){
		System.out.println(books);
		return booksService.addBooksDetails(books);
	}
}
