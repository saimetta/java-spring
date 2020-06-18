package com.saimetta.cloudnative.chapter5.demo;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	Customer findByEmail(String email);

}
