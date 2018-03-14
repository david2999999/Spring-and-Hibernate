package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + " : DOING DB WORK: ADDING AN ACCOUNT\n");
		
	}
	
	
	public boolean doWork() {
		
		System.out.println(getClass() + " : doWork()\n");
		return false;
	}


	public String getName() {
		System.out.println(getClass() + " : GetName()\n");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + " : SetName()\n");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + " : Get Service Code()\n");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : Set ServiceCode()\n");
		this.serviceCode = serviceCode;
	}
	
	
	
}
