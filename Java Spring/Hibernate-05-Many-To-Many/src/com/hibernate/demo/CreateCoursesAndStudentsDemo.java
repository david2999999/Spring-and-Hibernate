package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Review.class)
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Java Spring and Hibernate");
			
			// save the course
			System.out.println("Saving the course " + tempCourse);
			session.save(tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("Dav", "Liasw", "DavLi@gmail.com");
			Student tempStudent2 = new Student("Mia", "Qwer", "MiaQwe@gmail.com");
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			System.out.println("Saving the Students .....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved the students: " + tempCourse.getStudents());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			session.close();
			factory.close();
		}
	}

}













