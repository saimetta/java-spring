package com.saimetta.springtesting.baeldung;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 
    public Employee findByName(String name);
    
    public List<Employee> findAll();
    
    
}