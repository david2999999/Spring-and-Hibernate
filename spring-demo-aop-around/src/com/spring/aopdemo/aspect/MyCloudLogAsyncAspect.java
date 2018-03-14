package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyCloudLogAsyncAspect {

	
	@Before("com.spring.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("EXECUTING @BEFORE LOGGING TO CLOUD IN ASYNC");
	}
	
}
