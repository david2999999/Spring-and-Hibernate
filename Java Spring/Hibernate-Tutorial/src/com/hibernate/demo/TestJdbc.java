package com.hibernate.demo;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
	
		try {
			System.out.println("Connecting to database ");
			Connection myConnection = (Connection) DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connect successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
