package com.saimetta.cloudnativejava.chapter5.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findById(Long id) {
		return customerRepository.findById(id).map( c -> c).orElseThrow( () -> new CustomerNotFoundException(id));
	}

	@Override
	public void removeById(Long id) {
		customerRepository.findById(id).map( c -> { 
			customerRepository.deleteById(c.getId());
			return c;
		}).orElseThrow(() -> new CustomerNotFoundException(id));	
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		customerRepository.findAll().forEach(customerList::add);
		return customerList;
	}


}
