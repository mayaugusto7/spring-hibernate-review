package br.com.code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Student;
import br.com.code.hibernate.demo.utils.DateUtils;

public class PrimaryKeyDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
				
	   // create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// create object
			System.out.println("Creating new student object...");
			
			String theDateOfBirthStr = "31/12/1998";
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			
			Student student1 = new Student("José", "Augusto", "jose@hotmail.com", theDateOfBirth);
			
			// start transaction 
			session.beginTransaction();
			
			// save object
			System.out.println("Saving the students...");
			System.out.println(student1);
			session.save(student1);
			
			// commit transaction
			session.getTransaction().commit();
			
			// new code
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + student1.getId());
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: " + student1.getId());
			
			Student student = session.get(Student.class, student1.getId());
			
			System.out.println("Get complete: " + student);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}
	}

}
