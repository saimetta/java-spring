package com.saimetta.springtesting.baeldung;

import java.util.List;

public interface EmployeeService {
	Employee getEmployeeByName(String name);

	List<Employee> getAllEmployees();
}
