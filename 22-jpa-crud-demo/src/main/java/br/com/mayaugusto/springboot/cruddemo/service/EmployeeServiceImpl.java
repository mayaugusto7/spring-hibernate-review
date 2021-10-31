package br.com.mayaugusto.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mayaugusto.springboot.cruddemo.entity.Employee;
import br.com.mayaugusto.springboot.cruddemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeRepositoryJPAImpl") EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return this.employeeRepository.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		this.employeeRepository.deleteById(theId);
	}
}
