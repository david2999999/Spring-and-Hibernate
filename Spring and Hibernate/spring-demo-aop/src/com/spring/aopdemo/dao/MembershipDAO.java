package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSilly() {
		System.out.println(getClass() + " : DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + " : GOING TO SLEEP");
	}

}
