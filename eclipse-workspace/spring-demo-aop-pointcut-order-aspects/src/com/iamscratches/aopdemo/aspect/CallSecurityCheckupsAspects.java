package com.iamscratches.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class CallSecurityCheckupsAspects {
	
	@Before("com.iamscratches.aopdemo.aspect.LuvAOPExpressions.forDAOPackage()")
	public void callSecurityCheckup() {		
		System.out.println("\n========>>> Executing @Before advice on addAccount(), callSecurityCheckup");
	}	
}
