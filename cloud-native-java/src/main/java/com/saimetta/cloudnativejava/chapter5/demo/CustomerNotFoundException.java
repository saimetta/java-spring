package com.saimetta.cloudnativejava.chapter5.demo;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException(Long id) {
		super(String.format("The customer with id %s does not exist in our system", id));
	}

}
