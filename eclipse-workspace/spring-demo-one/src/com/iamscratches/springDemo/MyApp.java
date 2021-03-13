package com.iamscratches.springDemo;

public class MyApp {
	
	
	public static void main(String[] args) {
		// create the object
		Coach theCoach = new BaseballCoach();
		Coach newCoach = new TrackCoach();
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(newCoach.getDailyWorkout());
	}
	/*
	 * 1. App should be configurable
	 * 2. Easily change the Coach for another sport(Hockey, Baseball, Track...etc)
	 */
	
	/*	Spring container primary functions :
	 * Create and Manage objects(Inversion of Controls)
	 * Inject object dependencies(Dependency Injection) 
	 */
	
	/*There are many types of injection in Spring
	 * Two most common are constructor injection and setter injection.There is also auto-wiring
	 */

	/*
	 * Development process - Constructor injection
	 * Define the dependency interface and class
	 * Create a constructor in ur class for injections
	 * Configure the dependency in spring config file
	 */
	
	/*
	 * Development process - Setter injection
	 * Create setter methods in your class for injection
	 * Configure the dependency injection in Spring config file
	 */
	/* There are different scopes for spring beans namely :
	 * singleton, prototype, request, session, global-session;
	 */
	/*
	 * Bean Lifecycle:
	 * container started -> Bean instantiated -> Dependencies injected -> Internal spring processing -> Custom init method -> Custom destroy method -> STOP
	 * Development process:
	 * Define ur methods for init and destroy
	 * Configure the method names in Spring Config file
	 */
	/*Java annotations are special labels/markers added to java classes. It provides meta-data about the class and is processes at 
	 * compile time or run-time for special processing
	 * Development process:
	 * Enable component scanning in Spring config file
	 * Add the @Component Annotation to your java classes
	 * Retrieve bean from spring container
	 */

}
