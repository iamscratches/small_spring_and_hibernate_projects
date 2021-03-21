package com.iamscratches.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcURL);
			Connection myConn = DriverManager.getConnection(jdbcURL,user, pass);
			System.out.println("Connection Successfull!!");
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
/* Development process: To Do List
 * Add Hibernate Config file
 * Annotate config file
 * Develop java code to perform database operations
 */
/* ID generation strategies
 * GenerationType.AUTO
 * GenerationType.IDENTITY
 * GenerationType.SEQUENCE
 * GenerationType.TABLE
 */
/*Development process: One-to-One
 * Prep work- Define database tables
 * Create instructorDetails class
 * Create Instructor class
 * Create Main app
 */
