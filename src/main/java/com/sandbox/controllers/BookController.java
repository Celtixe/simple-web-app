package com.sandbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandbox.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepository;
	
	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("books")
	public String getBooks(Model m) {
		m.addAttribute("books", bookRepository.findAll());
		return "books";
	}
}
