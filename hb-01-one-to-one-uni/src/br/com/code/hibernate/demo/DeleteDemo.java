package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) throws ParseException {
		
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// start transaction 
			session.beginTransaction();

			// get instructor by primary key /id
			Long theId = 2L;
			Instructor instructor = session.get(Instructor.class, theId);
			System.out.println("Found instructor: " + instructor);
			
			// delete instructor
			if (instructor != null) {
				System.out.println("Deleting: " + instructor);
				session.delete(instructor);				
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}

	}

}
