package br.com.code.hibernate.demo.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = factory.getCurrentSession();
		
		try {
			int employeeId = 9;
			
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: " + employeeId);
			
			@SuppressWarnings("unused")
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			// System.out.println("Deleting employee: " + myEmployee);
			// session.delete(myEmployee);
			
			// delete student id 
			System.out.println("Deleting employee id = 9");
			session.createQuery("DELETE FROM Employee WHERE id = 9").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
