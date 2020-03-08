package com.santiago.aimetta.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}
	
	
	public List<Book> searchBooksByTitle(String titleQuery) {
		List<Book> books = new ArrayList<Book>();
		bookRepository.getAllBooksByTitle(titleQuery).forEach(books::add);
		return books;
	}
		
	public Book getBook(String id) {
		return bookRepository.findById(id).get();
	}
	
	public void addBook(Book book) {
		saveBook(book);
	}
	
	public void updateBook(Book book) {
		saveBook(book);
	}

	private void saveBook(Book book) {
		book.getChapters().forEach(chapter -> {
			System.out.println("Iterando chapters: "+chapter.toString());
			chapter.setBook(book);
		});
		book.getAuthors().forEach(author -> {
			author.setBook(book);
		});
		bookRepository.save(book);
	}
	
	public void deleteBook(String id) {
		bookRepository.deleteById(id);
	}
}
