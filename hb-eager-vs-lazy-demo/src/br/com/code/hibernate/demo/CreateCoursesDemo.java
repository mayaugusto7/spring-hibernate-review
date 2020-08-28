package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Course;
import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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

			Course c1 = new Course("Java Basic");
			Course c2 = new Course("Java Intermediate");
			Course c3 = new Course("Java Advanced");

			instructor.add(c1);
			instructor.add(c2);
			instructor.add(c3);

			session.save(c1);
			session.save(c2);
			session.save(c3);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
