package com.project.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {
	
	// set up logger
	private Logger myLogger  = Logger.getLogger(getClass().getName());
	
	// set pointcut declaration
	@Pointcut("execution(* com.project.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// do the same for service package and dao
	@Pointcut("execution(* com.project.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.project.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forDaoPackage() || forServicePackage() || forControllerPackage()")
	private void forAppFlow() {}
	
	// add @before returning advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("==> In @Before: calling method " + theMethod);
		
		// display the arguments to the method
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through and display arg
		for(Object tempArg : args) {
			myLogger.info("====> arguments: " + tempArg);
		}
	}
	
	// add @after returning advice
	@AfterReturning(
				pointcut="forAppFlow()",
				returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("==> In @AfterReturning: from method " + theMethod);
		
		// display data returned
		myLogger.info("===> result: " + theResult);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
