package com.spring.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.spring.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\nEXECUTING @AROUND ADVICE METHOD: " + method);
		
		// get being time stamp
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = null;
		
		
		try {
			
			result = theProceedingJoinPoint.proceed();
			
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			throw e;
		}
		
		// get end time stamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end - begin;
		myLogger.info("\n Duration: "  + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\nEXECUTING @AFTER FINALLY ON METHOD: " + method);

	}
	
	
	@AfterThrowing(
			pointcut= "execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\nEXECUTING @AFTER THROWING ON METHOD: " + method);
		
		// log the exception
		myLogger.info("The exception is " + theExc);
	}
	
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\nEXECUTING @AFTER RETURNING ON METHOD: " + method);
		
		
		// print out the results of the method call
		myLogger.info("Result is " + result);
		
		// lets post process the data -- modify it
		convertAccountNameToUpperCase(result);
		
		// print out the modified results
		myLogger.info("Modified Result is " + result);
		
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
		myLogger.info("EXECUTING @BEFORE ADVICE ON ADDACCOUNT!!");
		
		// display the method signature 
		MethodSignature methodSignature = (MethodSignature) theJoinpoint.getSignature();
		
		myLogger.info("Method: " + methodSignature);
		
		// display method arguments
		Object[] args = theJoinpoint.getArgs();
		
		// loop through arguments
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("Account name: " + theAccount.getName());
				myLogger.info("Account level: " + theAccount.getLevel());
			}
		}
		
		
	}
	

	
	
}
