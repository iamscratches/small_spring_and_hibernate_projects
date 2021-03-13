package com.iamscratches.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get bean from spring container
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class); 
		
		//call a method from the bean
		System.out.println(swimCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(swimCoach.getDailyFortune());
		
		//call our new SwimCoach methods that has the props value injected
		System.out.println(swimCoach.getEmail() + " \t " + swimCoach.getTeam());
		
		
		//close the context
		context.close();
	}


	
}
