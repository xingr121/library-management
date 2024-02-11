package com.jac.library.service;

import java.util.List;

import com.jac.library.entity.Book;

public interface BookService {

	List<Book> findAll();
	Book findById(int theId);
	void save(Book theBook);
	void deleteById(int theId);
	List<Book> findByTitleLike(String title);
}
