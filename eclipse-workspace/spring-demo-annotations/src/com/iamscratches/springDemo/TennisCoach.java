package com.iamscratches.springDemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
@Scope("prototype")
public class TennisCoach implements Coach {
	private FortuneService fortuneService;
	public String email, team;
	
	//define default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	//define my init method
		@PostConstruct
		public void doMyStartupStuffs() {
			System.out.println(">> TennisCoach: inside doMyStartupStuffs");
		}
		
		//define my destroy method
		// since prototype bean scopes doesn't do auto clean-ups it's the responsibility of the programmer to do the clean-ups
		@PreDestroy
		public void doMyCleanupStuffs() {			
			System.out.println(">> TennisCoach: inside doMyCleanupStuffs");
		}
	
	@Autowired	
	public TennisCoach(@Qualifier("databaseFortuneService")
	FortuneService fortuneService) {
		System.out.println(">> TennisCoach: inside parameterised constructor");
		this.fortuneService = fortuneService;
	}
	
	//setter/method injection
	@Autowired
	public void infoService(Info info) {
	// doesn't need to have set before the function as long as it s autowired as annotation the function name can be any function name
		System.out.println(">> TennisCoach: inside infoService");
		String str[] = info.getInfo();
		this.email = str[0];
		this.team = str[1];
	}

	@Override
	public String getDailyWorkout() {
		return "practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortuneService();
	}

}
