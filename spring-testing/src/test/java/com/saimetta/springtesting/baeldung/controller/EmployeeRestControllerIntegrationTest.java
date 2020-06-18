package com.saimetta.springtesting.baeldung.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.saimetta.springtesting.baeldung.Employee;
import com.saimetta.springtesting.baeldung.EmployeeRestController;
import com.saimetta.springtesting.baeldung.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRestController.class)
public class EmployeeRestControllerIntegrationTest {
 
    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private EmployeeService service;
 
    @Test
    public void When_GetEmployees_ThenReturnJsonArray()
      throws Exception {
         
        Employee alex = new Employee("alex");
     
        List<Employee> allEmployees = Arrays.asList(alex);
     
        Mockito.when(service.getAllEmployees()).thenReturn(allEmployees);
     
        mvc.perform(get("/api/employees")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(1)))
          .andExpect(jsonPath("$[0].name", is(alex.getName())));
    }
}