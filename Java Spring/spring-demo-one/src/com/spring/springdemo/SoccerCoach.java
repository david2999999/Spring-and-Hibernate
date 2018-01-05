package com.spring.springdemo;

public class SoccerCoach implements Coach{
	
	private FortuneService HappyFortuneService;
	
	
	public SoccerCoach(FortuneService happyFortuneService) {
		HappyFortuneService = happyFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Kick the Ball for 10 miles";
	}

	@Override
	public String getDailyFortune() {
		return HappyFortuneService.getFortune();
	}
	
}
