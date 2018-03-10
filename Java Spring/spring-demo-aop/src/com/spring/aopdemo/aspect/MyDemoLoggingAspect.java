package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of the related adviced for logging
	
	// using @Before advice
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("EXECUTING @BEFORE ADVICE ON ADDACCOUNT!!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
