package br.com.mayaugusto.springboot.cruddemo.repository;

import java.util.List;

import br.com.mayaugusto.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee employee);
	
	void deleteById(int theId);
}
