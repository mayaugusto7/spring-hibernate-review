package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			// create object cascade save
			System.out.println("Creating new object");
			
			Instructor instructor = new Instructor("Maycon", "Ribeiro", "maycon_ribeiro@hotmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/channel/mayaugusto", "Play Soccer");
			
		
			// associate objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start transaction 
			session.beginTransaction();
			
			// save instructor
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}

	}

}
