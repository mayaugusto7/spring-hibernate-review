package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Course;
import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;
import br.com.code.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

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

			// create a course
			Course course = new Course("Pacman - How To SCore One Million Points");
			
			// add some reviews
			course.addReview(new Review("Great course ... loved it!"));
			course.addReview(new Review("Cool course, job well done"));
			course.addReview(new Review("What a dumbn course, you are an idiot!"));
			
			// save the course ... and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());
			
			session.save(course);
			
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
