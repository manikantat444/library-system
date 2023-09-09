package com.library.system.controllers;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.system.entities.BookDetails;
import com.library.system.exceptions.BookDetailsNotProvidedException;
import com.library.system.exceptions.BookNameEmptyException;
import com.library.system.services.LibrarySystemService;

@RestController
@RequestMapping("/library")
public class LibrarySystemController {

	@Autowired
	private LibrarySystemService librarySystemService;

	@PostMapping("/addNewBook")
	public void addNewBook(@RequestBody BookDetails bookDetails) {

		librarySystemService.addNewBook(bookDetails);
	}

	@PutMapping("updateBook/{id}")
	public void updateBook(@PathVariable int id, @RequestBody(required = false) BookDetails bookDetails) {

		
		librarySystemService.updateBook(id, bookDetails);
	}

	@GetMapping("/getGenres")
	public String[] getGenres() {

		return librarySystemService.getGenres();
	}

	@GetMapping("/getBooksByGenre/{genre}")
	public List<BookDetails> getBookByGenre(@PathVariable String genre) {

		return librarySystemService.getBooksByGenre(genre);
	}
}
