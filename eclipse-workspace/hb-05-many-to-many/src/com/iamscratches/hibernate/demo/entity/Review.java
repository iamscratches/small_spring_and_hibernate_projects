package com.iamscratches.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

	// define the fields
	
	//define the constructors
	
	//define the getters and setters
	
	//define toString()
	
	//annotate the fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String comment;

	public Review(String comment) {
		super();
		this.comment = comment;
	}
	
	public Review() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	
	
}
