package com.santiago.aimetta.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.aimetta.message.Message;
import com.santiago.aimetta.message.MessageService;
import com.santiago.aimetta.message.SystemMessage;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(method = RequestMethod.POST,path = "/books")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
		messageService.addMessage(new Message("New book created:"+book.getName()));
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "/books/{id}")
	public void updateBook(@RequestBody Book book, @PathVariable String id) {
		bookService.updateBook(book);
		messageService.addMessage(new SystemMessage("The book "+book.getName()+" was updated"));

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/books/{id}")
	public void deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
		messageService.addMessage(new SystemMessage("The book with id"+id+" was deleted"));

	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/books")
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		bookService.getAllBooks().forEach(books::add);
		return books;
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/books/{id}")
	public Book getBook(@PathVariable String id) {
		return bookService.getBook(id);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,path = "/books/title-search/{query}")
	public List<Book> searchByTitle(@PathVariable String query) {
		List<Book> books = new ArrayList<Book>();
		bookService.searchBooksByTitle(query).forEach(books::add);
		return books;
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/books/author-search/{query}")
	public List<Book> searchByAuthor(@PathVariable String query) {
		List<Book> books = new ArrayList<Book>();
		bookService.searchBooksByAuthorName(query).forEach(books::add);
		return books;
	}
}
