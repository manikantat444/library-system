package com.library.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.system.entities.BookDetails;
import com.library.system.exceptions.BookAlreadyExistingException;
import com.library.system.exceptions.BookNotFoundException;
import com.library.system.repos.LibrarySystemRepository;

@Service
public class LibrarySystemService {

	@Autowired
	private LibrarySystemRepository librarySystemRepository;

	public void addNewBook(BookDetails bookDetails) {
		
		Optional<BookDetails> findByBookName = Optional.ofNullable(librarySystemRepository.findByBookName(bookDetails.getBookName()));
		if(findByBookName.isPresent()) {
			throw new BookAlreadyExistingException("Book already present!");
		}
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
		String[] findGenres = librarySystemRepository.findGenres();
		if(findGenres.length==0) {
			throw new GenreNotFoundException("Genres not found in library!");
		}
		return findGenres;
	}

	public List<BookDetails> getBooksByGenre(String genre) {

		List<BookDetails> books = librarySystemRepository.findByGenre(genre);
		if(books.size()==0) {
			throw new BookNotFoundException("Books not found with requested genre="+genre);
		}
		return books;
			
	}
}

