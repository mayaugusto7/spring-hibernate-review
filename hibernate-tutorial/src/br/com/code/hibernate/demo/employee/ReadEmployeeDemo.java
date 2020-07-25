package br.com.code.hibernate.demo.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// start transaction 
			session.beginTransaction();
			
			// save object
			System.out.println("Reading employee object");
			Employee employee = session.get(Employee.class, 9L);
			System.out.println("Employee: "  + employee);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}

	}

}
