package com.iamscratches.hibernate.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	//Create session factory
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			// create 3 student objects
			System.out.println("Creating 3 new Student object...");
			Student tempStudent1 = new Student("Yashashwi Kumar", "Saxena", "Yahashwi90@gmail.com");
			Student tempStudent2 = new Student("Sayantan", "Chakrabarty", "Sayantan1998@gmail.com");
			Student tempStudent3 = new Student("Tanishq", "Sharma", "TSharma2020@gmail.com");
			
			//start transaction
			session.beginTransaction();
						
			//save the student object
			System.out.println("saving the students... " );
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
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
