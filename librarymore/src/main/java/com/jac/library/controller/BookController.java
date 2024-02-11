package com.jac.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jac.library.service.BookService;

import jakarta.validation.Valid;

import java.util.List;
import com.jac.library.entity.Book;

@Controller
@RequestMapping("books")
public class BookController {

	private BookService bookService;

	public BookController(BookService theBookService) {
		bookService = theBookService;
	}
	
	@GetMapping("/")
	public String showHome() {
		return "books/home";
	}
	
	@GetMapping("/searchBook")
	public String showSearch(@RequestParam("bookTitle") String title,Model theModel) {
List<Book> theBooks = bookService.findByTitleLike(title);
		
		theModel.addAttribute("books", theBooks);
		return "books/search-book";
	}
	
	@GetMapping("/editBook")
	public String showAdminPanel() {
		return "books/edit-book";
	}
	
	@GetMapping("/list")
	public String listBooks(Model theModel) {
		List<Book> theBooks = bookService.findAll();
		
		theModel.addAttribute("books", theBooks);
		
		return "books/list-books";
	}
	
	@GetMapping("editBook/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Book theBook = new Book();
		theModel.addAttribute("book", theBook);
		return "books/book-form";
	}
	
	@GetMapping("editBook/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {
		Book theBook = bookService.findById(theId);
		theModel.addAttribute("book", theBook);
		return "books/book-form";
	}
	
	@PostMapping("editBook/save")
	public String saveBook(@Valid @ModelAttribute("book") Book 
	theBook,BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "books/book-form";
		}else {
			 bookService.save(theBook);
	       return "redirect:/books/list";
		}
	
	}
	
	@GetMapping("editBook/delete")
	public String delete(@RequestParam("bookId") int theId) {
		
		bookService.deleteById(theId);
		
		return "redirect:/books/list";
	}
	
}
