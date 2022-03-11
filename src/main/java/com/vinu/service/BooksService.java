package com.vinu.service;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinu.dao.BooksRepository;
import com.vinu.model.Books;


@Service
public class BooksService {

	@Autowired
	BooksRepository booksRepository;
	
	public String getbooksbyId(int bookid) {
		// TODO Auto-generated method stub
		return booksRepository.getbooksbyId(bookid);
		
	}

	public String deletebooksbyId(int bookid) {
		return booksRepository.deletebooksbyId(bookid);
	}

	public String updateBookDetails(int booknum, String bookName) {
		return booksRepository.updateBookDetails(booknum,bookName);
	}

	public Map getAllBooks() {
		return booksRepository.getAllBooks();
	}

	public String addBooksDetails(Books books) {
		return booksRepository.addBooksDetails(books);
	}

	
	
	
	

}
