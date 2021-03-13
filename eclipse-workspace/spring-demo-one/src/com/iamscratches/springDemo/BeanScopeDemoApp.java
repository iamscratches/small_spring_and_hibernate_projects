package com.iamscratches.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from spring container
		Coach trackCoach = context.getBean("trackCoach", Coach.class);
		Coach secondTrackCoach = context.getBean("trackCoach", Coach.class);
		
		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		Coach secondBaseballCoach = context.getBean("baseballCoach", Coach.class);
		
		//Check if they are same
		boolean result = (trackCoach == secondTrackCoach);
		System.out.println("new Memory created for track coach is " + !result);
		System.out.println("new Memory created for baseball coach is " + trackCoach + ", " + secondTrackCoach);
		result = (baseballCoach == secondBaseballCoach);
		System.out.println("new Memory created for baseball coach is " + !result);
		System.out.println("new Memory created for baseball coach is " + baseballCoach + ", " + secondBaseballCoach);
		// close the context
		context.close();

	}

}
