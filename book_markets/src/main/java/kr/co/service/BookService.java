package kr.co.service;


import kr.co.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookService {
	List<Book> getAllBookList();
	List<Book> getBookListByCategory(String category);
	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
	Book getBookById(String bookId);
	void setNewBook(Book book);
	void setUpdateBook(Book book);
	 void setDeleteBook(String bookID);
}
