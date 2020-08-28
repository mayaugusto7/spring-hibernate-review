package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Course;
import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) throws ParseException {
		
		// create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = factory.getCurrentSession();
		
		try {
	
			System.out.println("Creating new instructor");
			
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
			session.close();
			factory.close();
		}

	}
}
