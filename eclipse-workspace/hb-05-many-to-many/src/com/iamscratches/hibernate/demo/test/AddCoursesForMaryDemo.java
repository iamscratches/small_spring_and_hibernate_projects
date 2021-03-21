package com.iamscratches.hibernate.demo.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Course;
import com.iamscratches.hibernate.demo.entity.Instructor;
import com.iamscratches.hibernate.demo.entity.InstructorDetail;
import com.iamscratches.hibernate.demo.entity.Review;
import com.iamscratches.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			//get the student mary from the database
			int studentID = 7;
			Student tempStudent = session.get(Student.class, studentID);
			
			System.out.println("\nLoading the student : " + tempStudent);
			System.out.println("Course : " + tempStudent.getCourses());			
			
			//create more courses
			Course tempCourse1 = new Course("Rubik's cube : How to speed cube");
			Course tempCourse2 = new Course("Atari 2600 : Game Development");
			Course tempCourse3 = new Course("Angular");
			Course tempCourse4 = new Course("MEAN stack: MongoDB, ExpressJS, NodeJS, Angular");
			Course tempCourse5 = new Course("Cryptocurrency");
			Course tempCourse6 = new Course("Banking and accountancy");
			
			//add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			tempCourse3.addStudent(tempStudent);
			tempCourse4.addStudent(tempStudent);
			tempCourse5.addStudent(tempStudent);
			tempCourse6.addStudent(tempStudent);
			
			//save the courses
			System.out.println("\nSaving the courses...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			session.save(tempCourse4);
			session.save(tempCourse5);
			session.save(tempCourse6);
			
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
