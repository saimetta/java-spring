package com.saimetta.cloudnativejava.chapter2.psa;

import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.saimetta.cloudnativejava.chapter2.Customer;

@Component
public class CustomerService {

	private final JdbcTemplate jdbcTemplate;
	
	public CustomerService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Collection<Customer> findAll() {
		RowMapper<Customer> rowMapper = (rs, i) -> new Customer(rs.getLong("ID"), rs.getString("EMAIL"));
		return jdbcTemplate.query("SELECT * FROM CUSTOOMERS ", rowMapper);
	}
}
