package com.santiago.aimetta.publisher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.aimetta.message.Message;
import com.santiago.aimetta.message.MessageService;

@RestController
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/publishers")
	public List<Publisher> getAllPublishers() {
		return publisherService.getAllPublishers();
	}
	
	@RequestMapping("/publishers/{id}")
	public Publisher getPublisher(@PathVariable String id) {
		return publisherService.getPublisher(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/publishers")
	public void addPublisher(@RequestBody Publisher publisher) {
		publisherService.addPublisher(publisher);
		messageService.addMessage(new Message("New publisher: "+publisher.getName()));
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/publishers/{id}")
	public void updatePublisher(@RequestBody Publisher publisher,@PathVariable String id) {
		publisherService.updatePublisher(publisher);
		messageService.addMessage(new Message("Updated publisher: "+publisher.getName()));

	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/publishers/{id}")
	public void deletePublisher(@PathVariable String id) {
		publisherService.deletePublisher(id);
		messageService.addMessage(new Message("Removed publisher (code): "+id));

	}
}
