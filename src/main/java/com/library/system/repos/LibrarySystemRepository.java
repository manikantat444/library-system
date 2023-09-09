package com.library.system.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.system.entities.BookDetails;

@Repository
public interface LibrarySystemRepository extends JpaRepository<BookDetails, Integer> {

	@Query(value = "select distinct genre from book_details",nativeQuery = true)
	public String[] findGenres();
	
	public List<BookDetails> findByGenre(String genre);
}
