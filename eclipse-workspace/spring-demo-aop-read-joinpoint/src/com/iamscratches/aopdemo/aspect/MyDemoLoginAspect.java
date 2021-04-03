package com.iamscratches.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.iamscratches.aopdemo.dao.AccountDAO;

@Aspect
@Component
@Order(10)
public class MyDemoLoginAspect {

	// this is where we add all the related advises for logging
		
	@Before("com.iamscratches.aopdemo.aspect.LuvAOPExpressions.forDAOPackage()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {		
		System.out.println("\n========>>> Executing @Before advice on addAccount(),");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method : " + methodSignature);
		
		//display argument methods		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		//loop through 
		for(Object tempArg : args) {
			System.out.println(tempArg);
			if(tempArg instanceof AccountDAO) {
				// downcast and print Account specific stuff
				AccountDAO theAccountDAO = (AccountDAO)tempArg;
				System.out.println("account name : " + theAccountDAO.getStr());
				System.out.println("account level : " + theAccountDAO.getN());
				System.out.println("account amount : " + theAccountDAO.getD());
			}
		}
		
	}
}
