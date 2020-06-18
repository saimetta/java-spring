package com.saimetta.cloudnative.chapter5.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	
	@MockBean
	private CustomerRepository customerRepository;
	private CustomerService customerService;
	
	
	
	@Before
	public void setUp() {
		Customer customer = new Customer("customer@company.com");
		Optional<Customer> value = Optional.of(customer);
		Mockito.when(customerRepository.findById(1L)).thenReturn(value);
		Mockito.when(customerRepository.findById(2L)).thenThrow(CustomerNotFoundException.class);
		customerService = new CustomerServiceImpl(customerRepository);	
	}
	
	@Test
	public void When_FindById_ThenCorrect() {
		Customer found = customerService.findById(1L);
		assertEquals("customer@company.com", found.getEmail());
	}
	
	@Test
	public void When_FindByNonExistingId_ThenThrowException() {
		assertThrows(CustomerNotFoundException.class, () -> {
			 customerService.findById(2L);
		});
	}
}
