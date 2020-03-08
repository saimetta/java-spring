package com.santiago.aimetta.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public void addMessage(Message message) {
		messageRepository.save(message);
	}
	
	public Message getMessage(Long id) {
		return messageRepository.findById(id).get();
	}
}
