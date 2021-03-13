package com.iamscratches.springDemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		String str[] = {"Today is your lucky day", "U are definitely going to score today", "U are going to be the hero tonight"};
		Random rand = new Random();
		
		return str[rand.nextInt(3)];
	}

}
