package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membershipdao from the spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// call the AccountDAO getters and setters
		theAccountDAO.setName("FOOOO");
		theAccountDAO.setServiceCode("ORANGE");
		
		String name = theAccountDAO.getName();
		String service = theAccountDAO.getServiceCode();
		
		// call the business method from membershipDAO
		theMembershipDAO.addSilly();
		theMembershipDAO.goToSleep();
	
		// close the context
		context.close();
		
	}

}
