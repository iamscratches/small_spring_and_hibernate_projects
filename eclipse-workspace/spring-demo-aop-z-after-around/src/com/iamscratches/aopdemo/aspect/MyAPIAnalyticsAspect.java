package com.iamscratches.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-10)
public class MyAPIAnalyticsAspect {
	
	@Before("com.iamscratches.aopdemo.aspect.LuvAOPExpressions.forDAOPackage()")
	public void performAPIAnalytics() {		
		System.out.println("\n========>>> Executing @Before advice on addAccount(), performAPIAnalytics");
	}
}
