package com.iamscratches.springDemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {}
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it: " + fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuffs() {
		System.out.println("TrackCoach: inside method doMyStartupStuffs");
	}
	
	// add a destroy method
	public void doMyCleanupStuffs() {
		System.out.println("TrackCoach: inside method doMyCleanupStuffs");
	}

}
