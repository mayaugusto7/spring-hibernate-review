package br.com.mayaugusto.springboot.cruddemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mayaugusto.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeRepositoryJPAImpl implements EmployeeRepository {
	
	private final EntityManager entityManager;

	@Autowired
	public EmployeeRepositoryJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		
		Query query = this.entityManager.createQuery("FROM Employee");
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Employee employee = this.entityManager.find(Employee.class, theId);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
	
		Employee dbEmployee = this.entityManager.merge(employee);
	
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		Query query = this.entityManager.createQuery("DELETE FROM Employee WHERE id=:employeeId");
		
		query.setParameter("employeeId", theId);
		
		query.executeUpdate();
	}

}
