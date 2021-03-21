package com.iamscratches.hibernate.demo.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Course;
import com.iamscratches.hibernate.demo.entity.Instructor;
import com.iamscratches.hibernate.demo.entity.InstructorDetail;
import com.iamscratches.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
						
			//get the course
			int Id = 10;
			Course course = session.get(Course.class, Id);
			
			//print the course
			System.out.println("Deleting the course... ");
			System.out.println(course);
			
			//delete the course
			session.delete(course);
			
			//print the course reviews
			System.out.println(course.getReviews());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
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
