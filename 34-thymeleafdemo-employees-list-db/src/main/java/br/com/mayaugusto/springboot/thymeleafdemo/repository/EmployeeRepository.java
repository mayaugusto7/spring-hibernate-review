package br.com.mayaugusto.springboot.thymeleafdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayaugusto.springboot.thymeleafdemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastNameAsc();
}
