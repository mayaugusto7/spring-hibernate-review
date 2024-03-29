package br.com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: " + studentId);
			
			@SuppressWarnings("unused")
			Student myStudent = session.get(Student.class, studentId);
			
			// System.out.println("Deleting student: " + myStudent);
			// session.delete(myStudent);
			
			// delete student id 
			System.out.println("Deleting stuend id = 2");
			session.createQuery("DELETE FROM Student WHERE id = 2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
