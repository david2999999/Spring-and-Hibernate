package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Employee;

public class HibernateExerciseCreate {
	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate2.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
	
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			//create an employee object
			System.out.println("Creating a new employee");
			Employee employee = new Employee("Tim", "Tao", "Google");
			Employee employee2 = new Employee("Chu", "Qwe", "Yahoo");
			Employee employee3 = new Employee("Atqw", "Tao", "Yahoo");
			Employee employee4 = new Employee("Lqwer", "Vww", "Amazon");
			Employee employee5 = new Employee("Masdqwe", "Wqwe", "Yahoo");
			Employee employee6 = new Employee("Adqw", "Masda", "Amazon");
			// starting a transaction 
			session.beginTransaction();
			
			// save the employee into the MySQL database 
			System.out.println("Saving the employee: " + employee);
			session.save(employee);
			session.save(employee2);
			session.save(employee3);
			session.save(employee4);
			session.save(employee5);
			session.save(employee6);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
		}finally {
			
			factory.close();
		}
	}
}
