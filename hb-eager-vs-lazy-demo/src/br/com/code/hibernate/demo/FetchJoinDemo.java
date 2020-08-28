package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import br.com.code.hibernate.demo.entity.Course;
import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) throws ParseException {

		SessionFactory factory = new Configuration().
													configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			//option2: Hiberante query with HQL
			
			
			long id = 1L;

			Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id =: theInstructorId", Instructor.class);
		
			// set parameter
			query.setParameter("theInstructorId", id);
			
			// execute query and get instructor
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Instructor: " + instructor);
			
			session.getTransaction().commit();
			
			session.close();

			System.out.println("The session is now closed!\n");
			
			// Resolver problema de carregamento lento
			// opção 1: call getter method while session is open
			
			
			System.out.println("Courses: " + instructor.getCourses()); // Exception sessao fechada antes da consulta
			
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}
}
