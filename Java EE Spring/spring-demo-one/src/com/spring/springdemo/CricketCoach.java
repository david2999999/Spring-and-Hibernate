package com.spring.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	// adding new fields to the class
	private String emailAddress;
	private String team;
	
	// create a no- arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor!");
	}
	
	// setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}
	
//	GETTER METHODS

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
