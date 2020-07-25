package br.com.code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Student;
import br.com.code.hibernate.demo.utils.DateUtils;

public class CreateStudentDemo {

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
			System.out.println("Creating new student object");
			
			String theDateOfBirthStr = "31/12/1998";
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			
			Student student = new Student("Rosa", "Ribeiro", "rosa@hotmail.com", theDateOfBirth);
			
			// start transaction 
			session.beginTransaction();
			
			// save object
			System.out.println("Saving the student...");
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			sessionFactory.close();
		}

	}

}
