package com.spring.springdemo;

public class HappyFortuneService implements FortuneService {

	private String[] fortuneArray = {"Fortune 1", "Fortune 2", "Fortune 3"};
	
	@Override
	public String getFortune() {
		return this.fortuneArray[(int) Math.floor(Math.random() * fortuneArray.length)];
	}

}
