package br.com.mayaugusto.springboot.cruddemo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mayaugusto.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeRepositoryHibernateImpl implements EmployeeRepository {

	private final EntityManager entityManager;

	@Autowired
	public EmployeeRepositoryHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		Session session = this.entityManager.unwrap(Session.class);

		Query<Employee> createQuery = session.createQuery("FROM Employee", Employee.class);

		List<Employee> employees = createQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		Session session = this.entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, theId);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {

		Session session = this.entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int theId) {

		Session session = this.entityManager.unwrap(Session.class);
		
		//Employee employee = session.get(Employee.class, theId);
		
		//session.delete(employee);
		
		@SuppressWarnings("rawtypes")
		Query createQuery = session.createQuery("DELETE FROM Employee WHERE id=:employeeId");
		
		createQuery.setParameter("employeeId", theId);
		
		createQuery.executeUpdate();
	}

}
