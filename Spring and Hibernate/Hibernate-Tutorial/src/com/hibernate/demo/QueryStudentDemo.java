package com.hibernate.demo;

import org.hibernate.Session;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			// query students: lastName = 'Wall'
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			
			// display students with last name of Wall
			System.out.println("\n\nStudents who have last name of Wall");
			displayStudents(theStudents);
			
			// query students: lastName='Wall' OR firstName='David'
			theStudents = 
					session.createQuery("from Student s where s.lastName='Wall' OR s.firstName='David'").getResultList();
					
			System.out.println("\n\nStudents who have the last name of Wall or the first name of David");
			displayStudents(theStudents);
			
			// query students: email that ends with gmail.com
			theStudents = session.createQuery("from Student s WHERE s.email LIKE '%@gmail.com'").getResultList();
			System.out.println("\n\nStudents who have email ending with gmail");
			displayStudents(theStudents);
					
					
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}













