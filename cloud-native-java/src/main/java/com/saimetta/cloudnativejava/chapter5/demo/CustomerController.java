package com.saimetta.cloudnativejava.chapter5.demo;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(method = RequestMethod.OPTIONS)
	public ResponseEntity<?> options() {
		return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.POST, 
										 HttpMethod.HEAD, HttpMethod.OPTIONS, 
										 HttpMethod.PUT, HttpMethod.DELETE
										 ).build();
	}
	
	@GetMapping
	public List<Customer> getList() {
		return customerService.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Customer get(@PathVariable Long id) {
		return customerService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		Customer newCustomer = customerService.save(customer);
		URI uri = MvcUriComponentsBuilder.fromController(
				getClass()).path("/{id}")
				.buildAndExpand(newCustomer.getId())
				.toUri();
		return ResponseEntity.created(uri).body(newCustomer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		customerService.removeById(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.HEAD)
	public ResponseEntity<?> head(@PathVariable Long id) {
		customerService.findById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> put(@PathVariable Long id,@RequestBody Customer customer) {
		Customer existing = customerService.findById(id);
		existing.setEmail(customer.getEmail());
		existing = customerService.save(existing);
		URI selfLink = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
		return ResponseEntity.created(selfLink).body(existing);
	}
}
