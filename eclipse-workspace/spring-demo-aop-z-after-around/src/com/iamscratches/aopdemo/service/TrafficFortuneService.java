package com.iamscratches.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(true) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		
		//return a fortune
		return "Expect heavy traffic this morning";
	}

}
