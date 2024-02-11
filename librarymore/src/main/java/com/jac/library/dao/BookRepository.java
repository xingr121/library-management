package com.jac.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jac.library.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

	List<Book> findByTitleLike(String title);
}
