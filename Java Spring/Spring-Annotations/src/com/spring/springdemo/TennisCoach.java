package com.spring.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	//using qualifier in constructor
//	@Autowired
//    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
//
//        System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
//        
//        fortuneService = theFortuneService;
//    }
	
	
	 // define my init method
//    @PostConstruct
//    public void doMyStartupStuff() {
//        System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
//    }
//    
//    // define my destroy method
//    @PreDestroy
//    public void doMyCleanupStuff() {
//        System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
//    }
	
	
	
	//define a setter method
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside setFortuenService() method");
//		this.fortuneService = fortuneService;
//	}
//	
////	@Autowired
////	public TennisCoach(FortuneService fortuneService) {
////		this.fortuneService = fortuneService;
////	}
//
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
//		this.fortuneService = fortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
