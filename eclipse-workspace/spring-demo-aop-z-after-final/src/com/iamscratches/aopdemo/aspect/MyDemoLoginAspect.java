package com.iamscratches.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.iamscratches.aopdemo.Account;

@Aspect
@Component
@Order(10)
public class MyDemoLoginAspect {

	// this is where we add all the related advises for logging
	
	//add a new advice for @After on the findAccounts method
	@After("execution(* com.iamscratches.aopdemo.dao.AccountDAO.findAccounts(*))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		//print out which method we are advising on
				String method = joinPoint.getSignature().toShortString();
				System.out.println("\n========>>> Executing @After(finally) on method : " + method);
				
	}
	
	//add a new advice for @AfterThrowing on the findAccounts method
	@AfterThrowing(
			pointcut = "execution(* com.iamscratches.aopdemo.dao.AccountDAO.findAccounts(*))",
			throwing = "theExc")
	public void AfterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
		//print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @AfterThrowing on method : " + method);
		
		//log the exception
		System.out.println("\n========>>> The exception is : " + theExc);
	}
	
	//add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.iamscratches.aopdemo.dao.AccountDAO.findAccounts(*))",
			returning = "result")
	public void AfterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		//print out which method we are advicing on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @AfterReturning on method : " + method);
		
		//print out the results of the method call
		System.out.println("\n========>>> result is : " + result);
		
		// let's post-process the data... let's modify it :-)
		
		//convert the account names to Uppercase
		ConvertAccountNamesToUppercase(result);
		
		System.out.println("\n========>>> result is : " + result);
		
	}
		
	private void ConvertAccountNamesToUppercase(List<Account> result) {
		// loop through accounts
		for(Account tempAccount: result) {		
			// get uppercase version of name
			String theUpperCase = tempAccount.getName().toUpperCase();
		
			// update the name of the account
			tempAccount.setName(theUpperCase);
		}
		
	}

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
			if(tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account)tempArg;
				System.out.println("account name : " + theAccount.getName());
				System.out.println("account level : " + theAccount.getLevel());
			}
		}
		
	}
}