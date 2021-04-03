package com.iamscratches.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String str;
	private int n;
	private double d;
	
	public String getStr() {
		System.out.println(getClass() + ": getStr");
		return str;
	}

	public void setStr(String str) {
		System.out.println(getClass() + ": setStr");
		this.str = str;
	}

	public int getN() {
		System.out.println(getClass() + ": getN");
		return n;
	}

	public void setN(int n) {
		System.out.println(getClass() + ": setN");
		this.n = n;
	}

	public double getD() {
		System.out.println(getClass() + ": getD");
		return d;
	}

	public void setD(double d) {
		System.out.println(getClass() + ": setD");
		this.d = d;
	}

	public void addAccount() {
		System.out.println(getClass() + ": Doing my DB work: Adding account");
	}

}
