package com.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		
		try {
			// add  a boolean flag to simulate exception
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
			
		} catch (Exception e) {
			System.out.println("\nMain program: CALLING EXCEPTION" + e);
		}

		
		// display the accounts
		System.out.println("\nMain program: AFTERTHROWING DEMO APP");
		System.out.println(theAccounts);
		
		// close the context
		context.close();
		
	}

}
