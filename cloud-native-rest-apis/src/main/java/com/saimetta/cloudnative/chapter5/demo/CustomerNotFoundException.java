package com.saimetta.cloudnative.chapter5.demo;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	
	public CustomerNotFoundException(Long id) {
		super(String.format("The customer with id %s does not exist in our system", id));
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

}
