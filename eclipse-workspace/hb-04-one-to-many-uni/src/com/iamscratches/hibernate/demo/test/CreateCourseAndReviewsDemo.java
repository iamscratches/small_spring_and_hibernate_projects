package com.iamscratches.hibernate.demo.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iamscratches.hibernate.demo.entity.Course;
import com.iamscratches.hibernate.demo.entity.Instructor;
import com.iamscratches.hibernate.demo.entity.InstructorDetail;
import com.iamscratches.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
						
			//create course
			Instructor instructor = new Instructor("John", "Doe", "John.Doe@outlook.com");
			InstructorDetail detail = new InstructorDetail("https://www.youtube.com/JohnDoeStockItAll", "Stock marketing");
			Course tempCourse = new Course("Stock Market and its ups and downs");
			instructor.setInstructorDetail(detail);		
			instructor.add(tempCourse);
			//add some reviews
			tempCourse.addReview(new Review("Great course...loved it"));
			tempCourse.addReview(new Review("cool course, job well done"));
			tempCourse.addReview(new Review("Loved it! Loved it! Loved it!"));
			tempCourse.addReview(new Review("Narration was a bit dull"));
			tempCourse.addReview(new Review("Don't know why wasn't there any subtitles"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
			tempCourse.addReview(new Review("Utter waste of money"));
			
			//save the course.. and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(instructor);
			session.save(tempCourse);
			
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
