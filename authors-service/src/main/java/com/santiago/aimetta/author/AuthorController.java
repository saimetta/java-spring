package com.santiago.aimetta.author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(method = RequestMethod.POST,path = "/authors")
	public void addAuthor(@RequestBody Author author) {
		authorService.addAuthor(author);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "/authors/{id}")
	public void updateAuthor(@RequestBody Author author, @PathVariable Long id) {
		authorService.updateAuthor(author);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/authors/{id}")
	public void deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);

	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/authors")
	public List<Author> getAllAuthors() {
		List<Author> authors = new ArrayList<Author>();
		authorService.getAllAuthors().forEach(a -> authors.add(a));
		return authors;
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/authors/{id}")
	public Author getAuthor(@PathVariable Long id) {
		return authorService.getAuthor(id);
	}
}
