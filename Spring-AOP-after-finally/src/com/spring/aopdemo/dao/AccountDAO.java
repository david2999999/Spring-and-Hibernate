package com.spring.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire){
		
		// for academic purpose ... simulate an exception
		if(tripWire) {
			throw new RuntimeException("TRIPPEED WIRED");
		}
		
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts
		Account temp1 = new Account("Steve", "Silver");
		Account temp2 = new Account("Lucus", "Platnum");
		Account temp3 = new Account("Josh", "Diamond");
		
		// add them to our account list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	
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
