package com.iamscratches.hibernate.demo.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Course;
import com.iamscratches.hibernate.demo.entity.Instructor;
import com.iamscratches.hibernate.demo.entity.InstructorDetail;
import com.iamscratches.hibernate.demo.entity.Review;
import com.iamscratches.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
						
			//create course
			Course tempCourse = new Course("Spring and Hibernate");
			
			//save the course
			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			
			//create the student
			Student student1 = new Student("Mary", "Poppins", "mary.poppins@gmail.com");
//			Student student2 = new Student("Yashashwi Kumar", "Saxena", "Yashashwi.Saxena@gmail.com");
//			Student student3 = new Student("Tanishq", "Sharma", "Tanishq.Sharma@gmail.com");
//			Student student4 = new Student("Biswayan", "Chattopadhyay", "Biswayan.Chattopadhyay@gmail.com");
//			Student student5 = new Student("Yukta", "Bhartia", "Yukta.Bhartia@gmail.com");
//			Student student6 = new Student("Utkarsh", "Shrivastava", "Utkarsh.Shrivastava@gmail.com");
			
			//add the course to the student
			tempCourse.addStudent(student1);
//			tempCourse.addStudent(student2);
//			tempCourse.addStudent(student3);
//			tempCourse.addStudent(student4);
//			tempCourse.addStudent(student5);
//			tempCourse.addStudent(student6);
			
			//save the students
			System.out.println("Saving students...");
			session.save(student1);
//			session.save(student2);
//			session.save(student3);
//			session.save(student4);
//			session.save(student5);
//			session.save(student6);
			System.out.println("Saved students" + tempCourse.getStudents());
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
