package com.iamscratches.hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentID = 1;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentID);
			
			Student myStudent = session.get(Student.class, studentID);
			System.out.println("updating Student... ");
			myStudent.setFirstName("Suvankar");
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("done");
			session.close();
			
			//New Code
			session = factory.openSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Updating email for all students...");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
