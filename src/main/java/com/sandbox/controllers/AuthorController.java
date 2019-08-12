package com.sandbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandbox.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}


	@GetMapping("authors")
	public String getAuthors(Model m) {
		m.addAttribute("authors",authorRepository.findAll());
		return "authors";
	}
}
