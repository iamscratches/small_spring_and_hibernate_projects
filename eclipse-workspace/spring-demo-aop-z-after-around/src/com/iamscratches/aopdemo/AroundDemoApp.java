 package com.iamscratches.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iamscratches.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		 //read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program : AroundDemoApp");
		
		System.out.println("Calling getFortune");
		String data;
		try {
		data = theTrafficFortuneService.getFortune();
		}catch(Exception e) {
			data = e.getMessage();
		}
		
		System.out.println("\nMy Fortune is : " + data);
		
		System.out.println("Finished");
		
		//close the context
		context.close();

	}

}
