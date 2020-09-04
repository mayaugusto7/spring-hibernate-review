package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Course;
import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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

			long id = 1L;

			Instructor instructor = session.get(Instructor.class, id);

			System.out.println("Instructor: " + instructor);
			
			System.out.println("Courses: " + instructor.getCourses());
			
//			List<Course> courses = instructor.getCourses();
//			System.out.println("Courses...");
//			for (Course c : courses) {
//				System.out.println("Course: " + c);
//			}
			
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
