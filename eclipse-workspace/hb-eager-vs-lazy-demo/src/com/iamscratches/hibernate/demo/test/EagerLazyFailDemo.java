package com.iamscratches.hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Course;
import com.iamscratches.hibernate.demo.entity.Instructor;
import com.iamscratches.hibernate.demo.entity.InstructorDetail;

public class EagerLazyFailDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
						
			// get the instructor from db
			int Id = 1;
			Instructor instructor = session.get(Instructor.class, Id);
			System.out.println("luv2code : Instructor : " + instructor);			
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			//since courses are lazy loaded... this should fail
			// get course for the instructor
			System.out.println("luv2code : Courses : " + instructor.getCourses());
			
			System.out.println("luv2code : Done!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
