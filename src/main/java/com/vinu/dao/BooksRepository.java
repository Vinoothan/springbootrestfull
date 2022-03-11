package com.vinu.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.vinu.model.Books;

@Repository
public class BooksRepository {
	/*
	 * @Autowired Model model;
	 */
	private static Map<Integer, String> map = new HashMap<Integer, String>();

	static {
		map.put(100, "java");
		map.put(101, "unix");
		map.put(102, "spring");
		map.put(103, "hibernate");
		map.put(104, "c++");
	}

	private boolean isBookPresent(int bookid) {
		return map.containsKey(bookid) ? true : false;

	}

	public String getbooksbyId(int bookid) {
		String bookName = map.get(bookid);
		boolean val = isBookPresent(bookid);
		if (val == true) {
			return bookName;
		} else
			return bookid + " not found";
	}

	public String deletebooksbyId(int bookid) {
		boolean val = isBookPresent(bookid);
		if (val == true) {
			map.remove(bookid);
			return bookid + " deleted successfully";
		} else {
			return bookid + " not found";
		}

	}

	public String updateBookDetails(int bookid, String bookName) {

		boolean val = isBookPresent(bookid);
		if (val == true) {
			map.put(bookid, bookName);
			return "book details updated successfully" + bookid + ":" + bookName;

		}
		return bookid + " not found";
	}

	public Map getAllBooks() {
		return map;
	}

	public String addBooksDetails(Books books) {

		boolean val = isBookPresent(books.getBookId());
		if (val == true) {
			return books.getBookName() + ":" + books.getBookId() + " is alredy present";
		}
		 map.put(books.getBookId(), books.getBookName());
		 return "BooksDetails Added Successfully";

	}

}
