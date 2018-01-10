package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object...");
			Student student = new Student("Paul", "Wall", "hello@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student object");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			
		}
	}

}













