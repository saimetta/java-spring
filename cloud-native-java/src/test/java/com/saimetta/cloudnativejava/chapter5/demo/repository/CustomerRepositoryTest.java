package com.saimetta.cloudnativejava.chapter5.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.saimetta.cloudnativejava.chapter5.demo.Customer;
import com.saimetta.cloudnativejava.chapter5.demo.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
	 
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void When_CreateCustomerAndFind_ThenCorrect() {
		Customer customer = new Customer("customer@company.com");
		entityManager.persist(customer);
		Customer found = customerRepository.findByEmail(customer.getEmail());
		assertEquals(customer.getEmail(), found.getEmail());
	}
	
	@Test
	public void When_CreateCustomerAndDelete_ThenCorrect() {
		Customer customer = new Customer("customer@company.com");
		entityManager.persist(customer);
		Customer found = customerRepository.findByEmail(customer.getEmail());
		customerRepository.deleteById(found.getId());
		assertEquals(Optional.empty(),customerRepository.findById(found.getId()));

	}
	
	@Test
	public void When_UpdateCustomer_ThenCorrect() {
		Customer customer = new Customer("customer@company.com");
		customer = entityManager.persist(customer);
		customer.setEmail("newcustomer@company.com");
		customerRepository.save(customer);
		assertEquals(customer.getEmail(), customerRepository.findById(customer.getId()).get().getEmail());
	}
}
