package com.spring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach theCoach2 = context.getBean("myCoach2", Coach.class);
		Coach theCoach3 = context.getBean("myCoach3", Coach.class);
		
//		// call method on the bean
//		System.out.println(theCoach.getDailyWorkout());
//		
//		// call the new method for fortunes
//		System.out.println(theCoach.getDailyFortune());
		
		// generating random fortunes
		System.out.println(theCoach2.getDailyFortune());
		System.out.println(theCoach3.getDailyFortune());
		
		// close the context
		context.close();
	}

}
