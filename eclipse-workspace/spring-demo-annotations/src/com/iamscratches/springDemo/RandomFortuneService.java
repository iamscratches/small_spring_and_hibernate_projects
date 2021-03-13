package com.iamscratches.springDemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortuneService() {
		String str[] = {"Today is your lucky day", "U are definitely going to score today", "U are going to be the hero tonight"};
		Random rand = new Random();
		
		return str[rand.nextInt(3)] + " from RandomFortuneService";
	}

}
