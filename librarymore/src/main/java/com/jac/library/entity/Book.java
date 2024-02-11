package com.jac.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book {

	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="book_title")
	@NotNull(message= " is required")
	@Size(min=1, message="Book title is required")
	private String title;
	
	@Column(name="author")
	@NotNull(message= " is required")
	@Size(min=1, message="Author is required")
	private String author;
	
	@Column(name="book_isbn")
	private String bookISBN;
	
	@Column(name="status")
	@NotNull(message= "Status is required")
	@Size(min=1, message="Status is required")
	private String status;

	//define constructors
	
	public Book() {
	}

	public Book(int id, String title, String author, String bookISBN, String status) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.bookISBN = bookISBN;
		this.status = status;
	}

	public Book(String title, String author, String bookISBN, String status) {
		this.title = title;
		this.author = author;
		this.bookISBN = bookISBN;
		this.status = status;
	}

	
	// define getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", bookISBN=" + bookISBN + ", status="
				+ status + "]";
	}
	
	
	
}
