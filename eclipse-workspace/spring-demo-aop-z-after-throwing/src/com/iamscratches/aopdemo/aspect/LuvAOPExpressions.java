package com.iamscratches.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAOPExpressions {
	@Pointcut("execution(* com.iamscratches.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}

}
