package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		
		// call the business method
		System.out.println("Running the business method again");
		theAccountDAO.addAccount();
		
		// close the context
		context.close();
		
	}

}
