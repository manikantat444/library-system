package com.library.system.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.system.entities.BookDetails;
import com.library.system.exceptions.BookNotFoundException;
import com.library.system.repos.LibrarySystemRepository;

@Service
public class LibrarySystemService {

	@Autowired
	private LibrarySystemRepository librarySystemRepository;

	public void addNewBook(BookDetails bookDetails) {
		librarySystemRepository.save(bookDetails);

	}

	public void updateBook(int id, BookDetails bookDetails) throws BookNotFoundException {

		BookDetails book = librarySystemRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book is not present with id = " + id));
		book.setAvailability(bookDetails.getAvailability());
		book.setBookName(bookDetails.getBookName());
		book.setGenre(bookDetails.getGenre());
		librarySystemRepository.save(book);

	}

	public String[] getGenres() {
		return librarySystemRepository.findGenres();
	}

	public List<BookDetails> getBooksByGenres(String genre) {

		return librarySystemRepository.findByGenre(genre);
	}
}
