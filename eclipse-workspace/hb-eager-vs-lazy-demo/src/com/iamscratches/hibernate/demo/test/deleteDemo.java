package com.iamscratches.hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Instructor;
import com.iamscratches.hibernate.demo.entity.InstructorDetail;

public class deleteDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			// get instructor by id
			int id = 6;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Found the instructor: " + instructor);
			System.out.println("instructor detail : " + instructor.getInstructorDetail());
			
			//delete the instructor
			if(instructor!=null) {
				System.out.println("Deleting instructor : " + instructor);
				// Note: this will also delete the detail object associated with it because of CascadeType.ALL
				session.delete(instructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
