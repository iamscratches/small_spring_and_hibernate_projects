package com.iamscratches.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iamscratches.aopdemo.dao.AccountDAO;
import com.iamscratches.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		 //read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		//display the results
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("-------");
		System.out.println(theAccounts + "\n\n");
		
		//close the context
		context.close();

	}

}
