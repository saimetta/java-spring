package com.saimetta.springtesting.baeldung.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.saimetta.springtesting.baeldung.Employee;
import com.saimetta.springtesting.baeldung.EmployeeRepository;
import com.saimetta.springtesting.baeldung.EmployeeService;
import com.saimetta.springtesting.baeldung.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {
 
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }
 
    @Autowired
    private EmployeeService employeeService;
 
    @MockBean
    private EmployeeRepository employeeRepository;
 
    @Before
    public void setUp() {
        Employee alex = new Employee("alex");
     
        Mockito.when(employeeRepository.findByName(alex.getName()))
          .thenReturn(alex);
    }
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Employee found = employeeService.getEmployeeByName(name);
      
         assertThat(found.getName())
          .isEqualTo(name);
     }
}