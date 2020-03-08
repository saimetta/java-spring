package com.santiago.aimetta.author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> getAllAuthors() {
		List<Author> authors = new ArrayList<>();
		authorRepository.findAll().forEach(a -> authors.add(a));
		return authors;
	}
	
	public Author getAuthor(Long id) {
		return authorRepository.findById(id).get();
	}
	
	public void addAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}
}
