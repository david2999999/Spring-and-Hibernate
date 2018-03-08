package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Review.class)
						.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Java Spring and Hibernate");
			
			// add some reviews
			tempCourse.addReview(new Review("Great Course!"));
			tempCourse.addReview(new Review("Need to have Spring Boot"));
			tempCourse.addReview(new Review("Need a Bigger project"));
			tempCourse.addReview(new Review("Need Another course"));
			
			// save the course and leverage the cascade all
			System.out.println("Saving the course: " + tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			session.close();
			factory.close();
		}
	}

}













