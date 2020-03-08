package com.santiago.aimetta.publisher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository publisherRepository;

	public List<Publisher> getAllPublishers() {
		List<Publisher> publishers = new ArrayList<>();
		publisherRepository.findAll().forEach(p -> publishers.add(p));
		return publishers;
	}
	
	public Publisher getPublisher(String id) {
		return publisherRepository.findById(id).get();
	}
	
	public void addPublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}
	
	public void updatePublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}
	
	public void deletePublisher(String id) {
		publisherRepository.deleteById(id);
	}
}
