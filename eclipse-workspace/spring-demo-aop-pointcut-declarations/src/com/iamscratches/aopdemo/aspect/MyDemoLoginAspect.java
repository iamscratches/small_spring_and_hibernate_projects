package com.iamscratches.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

	// this is where we add all the related advises for logging
	
	// let's start with an @Before advice
	@Pointcut("execution(* com.iamscratches.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {		
		System.out.println("\n========>>> Executing @Before advice on addAccount(), beforeAddAccountAdvice");
	}
	
	@Before("forDAOPackage()")
	public void performAPIAnalytics() {		
		System.out.println("\n========>>> Executing @Before advice on addAccount(), performAPIAnalytics");
	}
	
	@Before("forDAOPackage()")
	public void callSecurityCheckup() {		
		System.out.println("\n========>>> Executing @Before advice on addAccount(), callSecurityCheckup");
	}
	
	//create pointcut for getter methods
	@Pointcut("execution(* com.iamscratches.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//create pointcut for setter methods
	@Pointcut("execution(* com.iamscratches.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create pointcut: include package .. exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void exceptGettersAndSetters() {}
	
	@Before("exceptGettersAndSetters()")
	public void done() {
		System.out.println("\n========>>> Executing @Before advice on addAccount(), exceptGettersAndSetters");
	}
}
/*
 * execution pattern
 * execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
 * modifiers-patters => public, private, protected, default
 * return-type-pattern => int, String etc.
 * declaring-type-pattern => com.iamscratches.aopdemo.aspect
 * mathod-name-pattern => addAccount
 * param-pattern => (String pattern, int length, int breadth)
 * throws-pattern => throws IOException
 */
/*for param-pattern =>
 * 	()-matches a method with no arguments
 * 	(*)-matches a method with one argument of any type
 * 	(..)-matches a method with 0 or more arguments of any type
 */
