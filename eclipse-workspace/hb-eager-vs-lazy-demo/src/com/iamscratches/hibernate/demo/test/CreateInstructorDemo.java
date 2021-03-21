package com.iamscratches.hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Course;
import com.iamscratches.hibernate.demo.entity.Instructor;
import com.iamscratches.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			// Create the objects
			Instructor instructor = new Instructor("Subhankar", "Bhattacharyya", "subhankar.bhattacharyya@oracle.com");
			InstructorDetail instructorDetail = new InstructorDetail("https://www.scratches-31f84.web.app", "Love Coding!!!");
			
			// Associate the objects together
			System.out.println("Saving instructor: " + instructor);
			instructor.setInstructorDetail(instructorDetail);
			
			//start transaction
			session.beginTransaction();
						
			// save the instructor
			/*
			 * Note: this will also save the detail object coz of CascadeType.ALL
			 */
			session.save(instructor);
			
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
