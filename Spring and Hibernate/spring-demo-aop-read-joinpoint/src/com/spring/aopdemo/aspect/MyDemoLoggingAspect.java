package com.spring.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
