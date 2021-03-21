package com.iamscratches.hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.iamscratches.hibernate.demo.entity.Course;
import com.iamscratches.hibernate.demo.entity.Instructor;
import com.iamscratches.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			//option 2 : Hibernate query with HQL
			
						
			// get the instructor from db
			int Id = 1;
			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses "
					+ "where i.id=:theInstructorID", Instructor.class);
			//set the parameter on query
			query.setParameter("theInstructorID", Id);
			
			//execute query and get instructor
			Instructor instructor = query.getSingleResult();
			System.out.println("luv2code : Instructor : " + instructor);
									
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			System.out.println("luv2code : Session is now closed...\n");
			
			// get courses for the instructor
			System.out.println("luv2code : courses : " + instructor.getCourses());
			
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
