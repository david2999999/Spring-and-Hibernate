package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of the related adviced for logging
	
	// using @Before advice
	
	// Match methods with addAccount in any class
	// @Before("execution(public void addAccount())")
	
	// match only the addAccount method inside the AccountDAO class
	// @Before("execution(public void com.spring.aopdemo.dao.AccountDAO.addAccount())")
	
	// match any method method that starts with add
	// @Before("execution(public void add*())")
	
	// match any method that starts with add
	// @Before("execution(void add*())")

	// match any method that starts with add and any return type
	// @Before("execution(* add*())")
	
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("EXECUTING @BEFORE ADVICE ON ADDACCOUNT!!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
