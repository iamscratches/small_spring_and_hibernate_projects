package com.iamscratches.springDemo;

public class FootballCoach implements Coach {

	//define private fields for dependencies
	private FortuneService fortuneService;
	
	//define constructor for dependency injection
	public FootballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Dribble for 1hr";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
