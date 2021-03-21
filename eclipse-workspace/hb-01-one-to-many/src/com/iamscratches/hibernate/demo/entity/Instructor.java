package com.iamscratches.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//annotate the class as an entity and map to db table
@Entity
@Table(name="instructor")
public class Instructor {
	
	// annotate the fields with db column names
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column
		private int id;

		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column
		private String email;
		
	// **setup mapping to instructorDetail entity
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="instructor_detail_id")
		private InstructorDetail instructorDetail;
		
		@OneToMany(mappedBy = "instructor", 
				cascade={CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
		private List<Course> courses;
		
	 // create constructors
		public Instructor() {
			
		}
		
	// Define the fields
		public Instructor(String firstName, String lastName, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}
		
	// generate getters and setters methods
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public InstructorDetail getInstructorDetail() {
			return instructorDetail;
		}

		public void setInstructorDetail(InstructorDetail instructorDetail) {
			this.instructorDetail = instructorDetail;
		}
		
		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}
	
	// generate toString() method

		@Override
		public String toString() {
			return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", instructorDetail=" + instructorDetail + "]";
		}
		
	// add convenience methods for bidirectional relationship
		public void add(Course tempCourse) {
			if(courses == null) {
				courses = new ArrayList<>();
			}
			courses.add(tempCourse);
			tempCourse.setInstructor(this);
		}
		

}
