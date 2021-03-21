package com.iamscratches.hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Instructor;
import com.iamscratches.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			// get the instructor detail object
			int id = 6;
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			// print the instructor detail
			System.out.println("Instructor detail: " + detail);
			
			// print the associated instructor
			System.out.println("Associated Instructor : " + detail.getInstructor());
			
			// now let's delete the instructor detail
			System.out.println("Deleting instructor detail : " + detail);
			
			//remove the associated object reference
			//break the bi-directional link
			detail.getInstructor().setInstructorDetail(null);
			session.delete(detail);
						
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
