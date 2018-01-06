package com.spring.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of strings
	private String[] fortunes = {
		"Fortune Number 1", "Fortune Number 2", "Fortune Number 3"	
	};
	
	//create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(fortunes.length);
		String fortune = fortunes[index];
		return fortune;
	}

}
