package br.com.code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.code.hibernate.demo.entity.Instructor;
import br.com.code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();

			// get the instructor detail
			Long id = 4L;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

			// print instructor detail
			System.out.println("Instructor Detail: " + instructorDetail);

			// print instructor associated
			System.out.println("The associated instructor: " + instructorDetail.getInstructor());

			// now let's delete the instructor detail
			System.out.println("Deleting intructorDetail: " + instructorDetail);

			// remove the associated object reference
			// break bi-direcional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
