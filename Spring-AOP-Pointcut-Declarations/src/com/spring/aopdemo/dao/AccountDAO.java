package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + " : DOING DB WORK: ADDING AN ACCOUNT\n");
		
	}
	
	
	public boolean doWork() {
		
		System.out.println(getClass() + " : doWork()\n");
		return false;
	}
}
