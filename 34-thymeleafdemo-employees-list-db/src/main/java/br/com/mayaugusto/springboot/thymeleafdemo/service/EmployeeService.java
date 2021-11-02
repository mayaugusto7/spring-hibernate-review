package br.com.mayaugusto.springboot.thymeleafdemo.service;

import java.util.List;

import br.com.mayaugusto.springboot.thymeleafdemo.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee employee);
	
	void deleteById(int theId);
}
