package com.spring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SocketUtils;

public class SetterDemoApp {
	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		
		// call the getter methods for the literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();
	}
}
