package com.saimetta.cloudnativejava.chapter2.boot;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

	private final CustomerService customerService;
	
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	@GetMapping("/customers")
	public Collection<Customer> readAll() {
		return customerService.findAll();
	}
	
	@GetMapping("/customers/init")
	public String init() {
		if (!customerService.hasCustomers()) {
			customerService.createSantiagoCustomer();
			customerService.createVeroCustomer();
			return "customers created";
		}
		return "has customers";
		
	}
	
	@GetMapping("/customers/{id}")
	public Customer getById(@PathVariable(name = "id") Long id) {
		return customerService.findById(id);
	}
}
