package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Course;
import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;
import br.com.code.hibernate.demo.entity.Review;
import br.com.code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) throws ParseException {

		SessionFactory factory = new Configuration().
													configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// create a course
			Course course = new Course("Pacman3 - How To Score One Million Points");

			System.out.println("Saving the course...");
			session.save(course);
			System.out.println("Saved the course: " + course);
			
			Student student = new Student("Maycon", "Ribeiro", "maycon_ribeiro@hotmail.com");
			Student student2 = new Student("Maycon", "Augusto", "maycon_augusto@hotmail.com");
			
			course.addStudent(student);
			course.addStudent(student2);
			
			System.out.println("\nSaving students ...");
			session.save(student);
			session.save(student2);
			
			System.out.println("Saved students: " + course.getStudents());
			
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
