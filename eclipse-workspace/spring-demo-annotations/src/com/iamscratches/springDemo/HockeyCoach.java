package com.iamscratches.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {
	private FortuneService fortuneService;
	
	/* Will work perfectly fine
	 * As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary if the target bean only 
	 * defines one constructor to begin with. However, if several constructors are available, at least one must be annotated to teach
	 * the container which one to use.
	 * 
	 * I personally prefer to use the @Autowired annotation because it makes the code more readable. But as mentioned, the @Autowired is 
	 * not required for this scenario. 
	 */
	@Autowired
	@Qualifier("RESTFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "practise your strike and defence";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortuneService();
	}

}
