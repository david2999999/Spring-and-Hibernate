package com.hibernate.demo;

import org.hibernate.Session;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Employee;
import com.hibernate.demo.entity.Student;


public class HibernateExerciseQuery {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factory = new Configuration()
						.configure("hibernate2.cfg.xml")
						.addAnnotatedClass(Employee.class)
						.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query employees
			List<Employee> employee = session.createQuery("from Employee e where e.company='yahoo'").getResultList();
			
			//display the employee
			displayEmployee(employee);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

	private static void displayEmployee(List<Employee> employees) {
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}

}













