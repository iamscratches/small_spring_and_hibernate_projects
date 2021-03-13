package com.iamscratches.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get bean from spring container
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class); 
		Coach hockeyCoach = context.getBean("hockeyCoach", Coach.class);
		Coach basketballCoach = context.getBean("basketballCoach", Coach.class);
		
		//call a method from the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(hockeyCoach.getDailyWorkout());
		System.out.println(basketballCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		System.out.println(hockeyCoach.getDailyFortune());
		System.out.println(basketballCoach.getDailyFortune());
		
		//call email and team
		TennisCoach tennisCoach = context.getBean("thatSillyCoach", TennisCoach.class);
		System.out.println(tennisCoach.email + "\t" + tennisCoach.team);
		
		BasketballCoach bCoach = (BasketballCoach)basketballCoach;
		System.out.println(bCoach.email + "\t" + bCoach.team);
		
		//check for object reference
		if(bCoach == basketballCoach)
			System.out.println("basketBall coach has same memory reference of " + bCoach);
		if(tennisCoach!=theCoach)// if u check the output u will find that tennisCoach class is instantiated two times and both the times
								//  Parameterized constructor of the class gets called
			System.out.println("tennisCoach coach has different memory references at " + theCoach + " and " + tennisCoach);
		
		//close the context
		context.close();
	}


	
}
