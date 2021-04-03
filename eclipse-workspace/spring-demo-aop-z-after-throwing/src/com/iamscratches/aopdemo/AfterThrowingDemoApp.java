package com.iamscratches.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iamscratches.aopdemo.dao.AccountDAO;
import com.iamscratches.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		 //read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		try {
			//add a boolean flag to simulate an exception
			boolean tripWire = true;
			List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);
		
		//display the results
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("-------");
		System.out.println(theAccounts + "\n\n");
		}catch(Exception e) {
			System.out.println("\n\nMain program ... caught exception: " + e);
		}
		
		//close the context
		context.close();

	}

}
