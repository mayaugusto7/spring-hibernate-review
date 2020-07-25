package br.com.code.hibernate.demo.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// create object
			System.out.println("Creating new employee object");
			Employee employee = new Employee("Maycon", "Augusto", "Cast Group");
			
			// start transaction 
			session.beginTransaction();
			
			// save object
			System.out.println("Saving the employee...");
			session.save(employee);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}

	}

}
