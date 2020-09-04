package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Course;
import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;
import br.com.code.hibernate.demo.entity.Review;

public class GetCoursesAndReviewsDemo {

	public static void main(String[] args) throws ParseException {

		SessionFactory factory = new Configuration().
													configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// get the course
			Long id = 12L;
			Course course = session.get(Course.class, id);
			
			// print the course
			System.out.println("Course: " + course);
			
			// print the couse reviews
			System.out.println("Review: " + course.getReviews());
			
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
