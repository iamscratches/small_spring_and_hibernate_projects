package com.iamscratches.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

	// this is where we add all the related advises for logging
	
	// let's start with an @Before advice
	
	@Before("execution(public void com.iamscratches.aopdemo.*.*.*Account())")
	public void beforAddAccountAdvice() {
		
		System.out.println("\n========>>> Executing @Before advice on addAccount()");
	}
}
/*
 * execution pattern
 * execution(modifiers-pattern? return-type-pattern declaring-type-pattern? mathod-name-pattern(param-pattern) throws-pattern?)
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
