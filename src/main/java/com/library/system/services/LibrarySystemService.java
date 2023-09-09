package com.library.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.system.entities.BookDetails;
import com.library.system.exceptions.BookAlreadyExistingException;
import com.library.system.exceptions.BookDetailsNotProvidedException;
import com.library.system.exceptions.BookNameEmptyException;
import com.library.system.exceptions.BookNotFoundException;
import com.library.system.exceptions.GenreNotFoundException;
import com.library.system.repos.LibrarySystemRepository;

/**
 * @author manikanta
 *
 *@this class manages the library system
 */
@Service
public class LibrarySystemService {

	@Autowired
	private LibrarySystemRepository librarySystemRepository;

	/**
	 * @param bookDetails
	 * 
	 * @this method accepts book and inserts into db
	 */
	public void addNewBook(BookDetails bookDetails) {

		Optional<BookDetails> findByBookName = Optional
				.ofNullable(librarySystemRepository.findByBookName(bookDetails.getBookName()));
		if (findByBookName.isPresent()) {
			throw new BookAlreadyExistingException("Book already present!");
		}
		librarySystemRepository.save(bookDetails);

	}

	/**
	 * @param id
	 * @param bookDetails
	 * @throws BookNotFoundException
	 * 
	 * @this method accepts book_id and book details to update the book in db
	 */
	public void updateBook(int id, BookDetails bookDetails) throws BookNotFoundException {

		BookDetails book = librarySystemRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book is not present with id = " + id));

		bookDetails = Optional.ofNullable(bookDetails)
				.orElseThrow(() -> new BookDetailsNotProvidedException("Book details are not provided to update!"));
		Optional.ofNullable(bookDetails.getBookName())
				.orElseThrow(() -> new BookNameEmptyException("Book name should not be empty in request body!"));
		book.setAvailability(bookDetails.getAvailability());
		book.setBookName(bookDetails.getBookName());
		book.setGenre(bookDetails.getGenre());
		librarySystemRepository.save(book);

	}

	/**
	 * @return
	 * 
	 * @this method fetches all the genres from db
	 */
	public String[] getGenres() {
		String[] findGenres = librarySystemRepository.findGenres();
		if (findGenres.length == 0) {
			throw new GenreNotFoundException("Genres not found in library!");
		}
		return findGenres;
	}

	/**
	 * @param genre
	 * @return
	 * 
	 * @this method fetches all the books based on requested genre
	 */
	public List<BookDetails> getBooksByGenre(String genre) {

		List<BookDetails> books = librarySystemRepository.findByGenre(genre);
		if (books.size() == 0) {
			throw new BookNotFoundException("Books not found with requested genre=" + genre);
		}
		return books;

	}
}
