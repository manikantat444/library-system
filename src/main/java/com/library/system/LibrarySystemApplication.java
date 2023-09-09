package com.library.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.library.system.entities.BookDetails;
import com.library.system.repos.LibrarySystemRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class LibrarySystemApplication {
	
	@Autowired
	private LibrarySystemRepository repo;
	
	@PostConstruct
	public void initSql() {
		
		List<BookDetails> details = new ArrayList<>();
		details.add(new BookDetails(2,"Yes","To Kill a Mockingbird","Classic"));
		details.add(new BookDetails(3,"Yes","The Great Gatsby","Classic"));
		details.add(new BookDetails(4,"Yes","The Catcher in the Rye","Classic"));
		
		details.add(new BookDetails(5,"Yes","Pride and Prejudice","Romance"));
		details.add(new BookDetails(6,"Yes","The Notebook","Romance"));
		details.add(new BookDetails(7,"Yes","The Da Vinci","Thriller"));
		
		details.add(new BookDetails(8,"Yes","The Girl with the Dragon Tattoo","Thriller"));
		details.add(new BookDetails(9,"Yes","The Hunger Games","Science Fiction"));
		details.add(new BookDetails(10,"Yes","1984","Science Fiction"));
		
		repo.saveAll(details);
	}

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}

}
