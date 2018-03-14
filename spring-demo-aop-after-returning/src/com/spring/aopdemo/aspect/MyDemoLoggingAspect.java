package com.spring.aopdemo.aspect;

import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\nEXECUTING @AFTER RETURNING ON METHOD: " + method);
		
		
		// print out the results of the method call
		System.out.println("Result is " + result);
		
		// lets post process the data -- modify it
		convertAccountNameToUpperCase(result);
		
		// print out the modified results
		System.out.println("Modified Result is " + result);
		
	}
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		// loop through accounts
		for(Account tempAccount : result) {
			
			// get uppercase version of name
			String upperCaseName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(upperCaseName);
		}
		
	}

	@Before("com.spring.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {
		System.out.println("EXECUTING @BEFORE ADVICE ON ADDACCOUNT!!");
		
		// display the method signature 
		MethodSignature methodSignature = (MethodSignature) theJoinpoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		
		// display method arguments
		Object[] args = theJoinpoint.getArgs();
		
		// loop through arguments
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
		
		
	}
	

	
	
}
