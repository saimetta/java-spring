package com.saimetta.cloudnative.chapter5.demo;

import java.net.URI;

import org.springframework.hateoas.CollectionModel;
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
@RequestMapping(value = "/v2/customers", produces = "application/hal+json")
public class CustomerHypermediaRestController {

	private final CustomerService customerService;
	private final CustomerResourceAssembler customerResourceAssembler;
	
	public CustomerHypermediaRestController(
			CustomerService customerService,
			CustomerResourceAssembler customerResourceAssembler) {
		this.customerService = customerService;
		this.customerResourceAssembler = customerResourceAssembler;
	}
	
	@RequestMapping(method = RequestMethod.OPTIONS)
	public ResponseEntity<?> options() {
		return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.POST, 
										 HttpMethod.HEAD, HttpMethod.OPTIONS, 
										 HttpMethod.PUT, HttpMethod.DELETE
										 ).build();
	}
	
	@GetMapping
	public CollectionModel<CustomerDto> getList() {
		return customerResourceAssembler.convertToDtos(customerService.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> get(@PathVariable Long id) {
		CustomerDto dto = customerResourceAssembler.convertToDto(customerService.findById(id));
		return ResponseEntity.ok(dto);		
	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> create(@RequestBody Customer customer) {
		CustomerDto newCustomer = customerResourceAssembler.convertToDto(customerService.save(customer));
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
	public ResponseEntity<CustomerDto> put(@PathVariable Long id,@RequestBody Customer customer) {
		Customer existing = customerService.findById(id);
		existing.setEmail(customer.getEmail());
		CustomerDto dto = customerResourceAssembler.convertToDto(customerService.save(existing));
		URI selfLink = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
		return ResponseEntity.created(selfLink).body(dto);
	}

}
