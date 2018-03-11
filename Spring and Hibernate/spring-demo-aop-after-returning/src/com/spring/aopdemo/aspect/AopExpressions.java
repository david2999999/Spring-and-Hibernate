package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	// pointcut expression for all of the methods
		@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
		public void forDaoPackage() {}
		
		// pointcut expression for getter methods
		@Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
		public void getter() {}
		
		// pointcut expression for setter methods
		@Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
		public void setter() {}
		
		// pointcut expression: include package --- exclude getter/setter
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void forDaoPackageNoGetterSetter() {}
		
}
