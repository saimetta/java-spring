package com.saimetta.cloudnativejava.chapter2.boot;

import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	private final JdbcTemplate jdbcTemplate;
	
	public CustomerService(JdbcTemplate jdbcTemplate,
						   CustomerRepository customerRepository) {
		this.jdbcTemplate = jdbcTemplate;
		this.customerRepository = customerRepository;
	}
	
	public Collection<Customer> findAll() {
		RowMapper<Customer> rowMapper = (rs, i) -> new Customer(rs.getLong("ID"), rs.getString("EMAIL"));
		return jdbcTemplate.query("SELECT * FROM CUSTOMER ", rowMapper);
	}
	
	public void createSantiagoCustomer() {
		customerRepository.save(new Customer(1L, "santiago@mail.com"));
	}
	
	public void createVeroCustomer() {
		customerRepository.save(new Customer(2L, "vero@mail.com"));
	}
	
	public boolean hasCustomers() {
		return customerRepository.count() > 0;
	}
	
	public Customer findById(Long id) {
		return customerRepository.findById(id).get();
	}
}
