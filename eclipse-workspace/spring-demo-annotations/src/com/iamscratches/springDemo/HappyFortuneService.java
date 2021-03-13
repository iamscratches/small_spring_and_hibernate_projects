package com.iamscratches.springDemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortuneService() {
		return "Today is ur lucky day from HappyFortuneService";
	}

}
