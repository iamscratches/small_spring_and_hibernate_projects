package com.iamscratches.springDemo;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class BasketballCoach implements Coach {
	
	@Value("${foo.email}")
	public String email;
	    
	@Value("${foo.team}")
	public String team;
	
	// Field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	//define a default constructor
	public BasketballCoach() {
		System.out.println(">> BasketballCoach: inside the default constructor");
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuffs() {
		System.out.println(">> BasketballCoach: inside doMyStartupStuffs");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuffs() {
		System.out.println(">> BasketballCoach: inside doMyCleanupStuffs");
	}
	@Override
	public String getDailyWorkout() {
		return "practise hooking";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortuneService();
	}

}
