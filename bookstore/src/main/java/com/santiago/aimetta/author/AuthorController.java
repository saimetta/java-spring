package com.santiago.aimetta.author;

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
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(method = RequestMethod.POST,path = "/authors")
	public void addAuthor(@RequestBody Author author) {
		authorService.addAuthor(author);
		messageService.addMessage(new Message("New author created:"+author.getName()));
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "/authors/{id}")
	public void updateAuthor(@RequestBody Author author, @PathVariable Long id) {
		authorService.updateAuthor(author);
		messageService.addMessage(new SystemMessage("The author "+author.getName()+" was updated"));

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/authors/{id}")
	public void deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);
		messageService.addMessage(new SystemMessage("The author with id: "+id+" was deleted"));

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
