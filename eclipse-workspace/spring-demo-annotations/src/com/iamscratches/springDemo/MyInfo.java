package com.iamscratches.springDemo;

import org.springframework.stereotype.Component;

@Component
public class MyInfo implements Info {	
	public String email, team;
	
	public MyInfo() {
		System.out.println(">> inside MyInfo: MyInfo no-arg constructor");
		setInfo();
	}
	
	@Override
	public void setInfo() {
		System.out.println(">> inside MyInfo: MyInfo setInfo");
		email = "iamscratches@gmail.com";
		team = "Rajasthan Royals";
	}
	@Override
	public String[] getInfo() {
		String str[] = new String[2];
		str[0] = email;
		str[1] = team;
		return str;
	}
}
