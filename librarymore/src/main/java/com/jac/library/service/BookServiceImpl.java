package com.jac.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jac.library.dao.BookRepository;
import com.jac.library.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	
	private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository theBookRepository) {
		bookRepository = theBookRepository;
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int theId) {
		Optional<Book> result = bookRepository.findById(theId);
		Book theBook= null;
		if(result.isPresent()) {
			theBook=result.get();
		}else {
			throw new RuntimeException("Did not find book id - " + theId);
		}
		
		return theBook;
	}

	@Override
	public void save(Book theBook) {
		bookRepository.save(theBook);
		
	}

	@Override
	public void deleteById(int theId) {
		bookRepository.deleteById(theId);
		
	}

	@Override
	public List<Book> findByTitleLike(String title) {
		// TODO Auto-generated method stub
		Optional<List<Book>> booksOptional = Optional.ofNullable(bookRepository.findByTitleLike(title));
		List<Book> books=null;
		if (booksOptional.isPresent()) {
			books= booksOptional.get();
		} else {
			throw new RuntimeException("no result found");
		}
		return books;
	}

}
