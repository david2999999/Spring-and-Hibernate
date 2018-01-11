package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Employee;

import java.util.*;

public class HibernateExerciseDelete {
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
			
//			System.out.println("Deleting the employee with an id of 1");
//			session.delete(employee1);
			
			// deleting employee with an Id of 2
			session.createQuery("delete from Employee where id=2").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
		}finally {
			
			factory.close();
		}
	}
}
