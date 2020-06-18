package com.saimetta.cloudnative.chapter5.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;;


@Component
public class CustomerResourceAssembler  {

	public CustomerDto convertToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getEmail());
		customerDto.add(linkTo(CustomerHypermediaRestController.class).slash(customerDto.getId()).withSelfRel());
		customerDto.add(linkTo(methodOn(CustomerProfilePhotoController.class).read(customerDto.getId())).withRel("photo"));
		return customerDto;
	}
	
	public CollectionModel<CustomerDto> convertToDtos(List<Customer> customers) {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customers.forEach(c -> customerDtos.add(convertToDto(c)));
		Link link = linkTo(CustomerHypermediaRestController.class).withSelfRel();
		return new CollectionModel<>(customerDtos, link);
	}
}
