package com.iamscratches.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class MyDemoLoginAspect {

	// this is where we add all the related advises for logging
		
	@Before("com.iamscratches.aopdemo.aspect.LuvAOPExpressions.forDAOPackage()")
	public void beforeAddAccountAdvice() {		
		System.out.println("\n========>>> Executing @Before advice on addAccount(), beforeAddAccountAdvice");
	}
}
