package com.iamscratches.springDemo;

public class BaseballCoach implements Coach {
	
	//define private fields for dependencies
	private FortuneService fortuneService;
	
	public BaseballCoach() {}
	
	//define constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}

}
