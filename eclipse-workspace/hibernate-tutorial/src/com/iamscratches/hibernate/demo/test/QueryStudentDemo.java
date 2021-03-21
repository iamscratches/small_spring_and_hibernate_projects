package com.iamscratches.hibernate.demo.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {			
			//start transaction
			session.beginTransaction();
						
			// query students
			List<Student> theStudents = session.createQuery("select s from Student s").getResultList();// can also use just "from student"
			
			//display the students
			displayStudents(theStudents);
			
			// query students: lastName starts with 'Y' or 'B'
			theStudents = session.createQuery("select s from Student s where s.lastName like 'B%' or s.firstName like 'Y%'").getResultList();
			
			//display the students
			System.out.println("Students who have starting last name of B or first name of Y");
			displayStudents(theStudents);
			
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

	private static void displayStudents(List<Student> theStudents) {
		for (Iterator iterator = theStudents.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student);				
		}
	}

}
