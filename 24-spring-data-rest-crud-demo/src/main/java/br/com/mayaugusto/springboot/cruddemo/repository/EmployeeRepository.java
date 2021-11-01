package br.com.mayaugusto.springboot.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayaugusto.springboot.cruddemo.entity.Employee;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
