package com.iamscratches.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iamscratches.aopdemo.dao.AccountDAO;

public class NewMainDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		theAccountDAO.addAccount("iamscratches@gmail.com", 3, 300000.75);
		
		theAccountDAO.addAccount(theAccountDAO);

	}

}
