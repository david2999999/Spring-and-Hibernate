package com.spring.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Don't do it: " + fortuneService.getFortune();
	}
	
	// add an init method
	public void doStartupStuff() {
		System.out.println("TrackCoach: inside method doStartupStuff");
	}
	
	// add a destroy method
	public void doCleanupStuff() {
		System.out.println("TrackCoach: inside method doCleanupStuff");
	}

}












