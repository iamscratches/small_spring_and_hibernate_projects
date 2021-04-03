package com.iamscratches.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iamscratches.aopdemo.dao.AccountDAO;
import com.iamscratches.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		 //read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//get the membership bean from spring container
		MembershipDAO theMembershipdao = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		
		//call the membership method
		theMembershipdao.addAccount();
		
		//call the silly membership method
		theMembershipdao.addSillyMember();
		
		//Do it again!!
		System.out.println("\nlet's call it again!!");
		theAccountDAO.addAccount();
		
		//close the context
		context.close();

	}

}
