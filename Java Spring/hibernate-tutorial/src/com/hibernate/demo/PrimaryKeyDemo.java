package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
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
					Student student1 = new Student("Tim", "Tb", "hello123@gmail.com");
					Student student2 = new Student("Boni", "Li", "whatsup@gmail.com");
					Student student3 = new Student("Mary", "Xiu", "cow2@gmail.com");
					
					// start a transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the student object");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}finally {
					
				}
				
	}
}
