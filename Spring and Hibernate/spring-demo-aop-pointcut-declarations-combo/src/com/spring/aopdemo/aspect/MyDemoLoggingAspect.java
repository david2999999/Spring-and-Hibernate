package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// pointcut expression for all of the methods
	@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// pointcut expression for getter methods
	@Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// pointcut expression for setter methods
	@Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// pointcut expression: include package --- exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("EXECUTING @BEFORE ADVICE ON ADDACCOUNT!!");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("EXECUTING @BEFORE PERFORMING API ANALYTICS");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
