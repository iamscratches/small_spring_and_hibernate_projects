package com.iamscratches.hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			// create a student object
			System.out.println("Creating a new Student object...");
			Student tempStudent = new Student("Utkarsh","Shrivastava","foo@gmail.com");
			
			//start transaction
			session.beginTransaction();
						
			//save the student object
			System.out.println("saving the student... " );
			session.save(tempStudent);
			
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
