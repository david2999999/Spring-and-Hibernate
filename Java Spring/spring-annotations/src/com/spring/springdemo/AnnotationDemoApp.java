package com.spring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
	
		// read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the beans from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach theCoach2 = context.getBean("basketballCoach", Coach.class);
		
		// call the method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach2.getDailyWorkout());
		
		// close the context
		context.close();

	}

}
