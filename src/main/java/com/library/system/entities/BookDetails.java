package com.library.system.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private String availability;
	private String bookName;
	private String genre;
	
	

	public BookDetails() {
		
	}

	public BookDetails(int bookId, String availability, String bookName, String genre) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.genre = genre;
		this.availability = availability;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookName=" + bookName + ", genre=" + genre + ", availability="
				+ availability + "]";
	}

}
