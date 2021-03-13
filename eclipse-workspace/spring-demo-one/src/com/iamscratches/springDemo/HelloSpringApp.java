package com.iamscratches.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);// TrackCoach
		Coach newCoach = context.getBean("newCoach", Coach.class);// BaseballCoach
		Coach footballCoach = context.getBean("myFootballCoach", Coach.class);//FootballCoach
		Coach newFootballCoach = context.getBean("myFootballCoach", Coach.class);//To show that both refer to the same object
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout() + " | \t" + theCoach.getDailyFortune());
		System.out.println(newCoach.getDailyWorkout() + " | \t" + newCoach.getDailyFortune());
		
		// FootballCoach
		System.out.println(footballCoach.getDailyWorkout() + " | \t" + footballCoach.getDailyFortune());
		
		if(newFootballCoach == footballCoach) {
			System.out.println("no new reference is created:" + newFootballCoach + " | \tClassic example of singleton scope");
		}
		
		//close the context
		context.close();
		
	}

}
