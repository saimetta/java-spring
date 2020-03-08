package com.santiago.aimetta.book;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, String> {
	
	
	@Query("SELECT book FROM Book book WHERE book.name LIKE %:title%")
	public List<Book> getAllBooksByTitle(@Param("title") String query);
	
	@Query("SELECT book FROM Book book join book.authors author WHERE author.name LIKE %:name%")
	public List<Book> getAllBooksByAuthorName(@Param("name") String query);

}
