package com.iamscratches.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass() + ": Doing my DB work: Adding Membership account");
	}
	
	public void addSillyMember() {
		System.out.println(getClass() + ": Doing my DB work: Adding Silly Membership account");
	}

}
