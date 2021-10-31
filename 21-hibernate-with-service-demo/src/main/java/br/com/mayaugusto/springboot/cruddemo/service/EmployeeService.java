package br.com.mayaugusto.springboot.cruddemo.service;

import java.util.List;

import br.com.mayaugusto.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee employee);
	
	void deleteById(int theId);
}
