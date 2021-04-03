package com.iamscratches.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.iamscratches.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String serviceCode;
	private int name;

	public String getServiceCode() {
		return serviceCode;
	}



	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}



	public int getName() {
		return name;
	}



	public void setName(int name) {
		this.name = name;
	}
	
	// add a new method: findAccounts()
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();
		//create sample accounts
		Account temp1 = new Account("Subhankar", "Platinum");
		Account temp2 = new Account("Subhajyoti", "Gold");
		Account temp3 = new Account("Subarna", "Silver");
		Account temp4 = new Account("Tanishq", "Bronze");
		Account temp5 = new Account("Yukta", "General");
		
		//add them to our account list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		myAccounts.add(temp4);
		myAccounts.add(temp5);
		
		return myAccounts;
		
	}

	public void addAccount(Account theAccount, boolean vipFlap) {
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
	}

	public void addAccount() {
		System.out.println(getClass() + ": Doing my DB work: Adding account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
