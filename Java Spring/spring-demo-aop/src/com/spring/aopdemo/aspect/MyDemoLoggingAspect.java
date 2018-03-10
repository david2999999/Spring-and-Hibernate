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
	
	// match any method that starts with add and any return type
	// the argument that is passed in has to be the class Account
	// @Before("execution(* add*(com.spring.aopdemo.Account))")
	
	// match any method that starts with add and any return type
	// the argument starts with Account class then any number of arguments
	// @Before("execution(* add*(com.spring.aopdemo.Account, ..))")

	// match any method that starts with add and any return type
	// Any number of arguments
	// @Before("execution(* add*(..))")
	
	// match any class in the package
	// match any methods in the class
	// any number of arguments
	// any return type
	// @Before("execution(* com.spring.aopdemo.dao.*.*(..))")

	
	@Before("execution(* com.spring.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("EXECUTING @BEFORE ADVICE ON ADDACCOUNT!!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
