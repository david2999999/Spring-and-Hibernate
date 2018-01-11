package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Employee;

import java.util.*;

public class HibernateExerciseGet {
	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate2.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
	
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// begin a transaction
			session.beginTransaction();
			
			// retrieve the employee with Id = 1
			Employee employee1 = session.get(Employee.class, 1);
			
			System.out.println("Retrieved the employee with id: " + employee1);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
		}finally {
			
			factory.close();
		}
	}
}
