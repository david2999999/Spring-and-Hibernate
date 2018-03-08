package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// create  the objects for association
//			Instructor tempInstructor = 
//					new Instructor("David", "Qwerty", "qwerty@gmail.com");
//			InstructorDetail tempInstructorDetail = 
//					new InstructorDetail("qwerty@youtube.com", "Soccer");
			
			Instructor tempInstructor = 
					new Instructor("Tina", "Min", "qwerty12@gmail.com");
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("Tina2@youtube.com", "Violin");
			// associate the object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();

			// save the instructor
			// this will also save the instructor detail
			// because of CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

}













