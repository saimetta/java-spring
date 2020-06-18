package com.saimetta.cloudnativejava.chapter5.demo;

import java.util.List;

public interface CustomerService {

	Customer save(Customer customer);
	Customer findById(Long id);
	void removeById(Long id);
	List<Customer> findAll();
}
