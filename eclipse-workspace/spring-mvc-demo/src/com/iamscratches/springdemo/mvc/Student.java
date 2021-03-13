package com.iamscratches.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName, lastName, country, favouriteLanguage;
	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> operatingSystemsOptions;
	private String[] operatingSystems;
	
	
	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student() {
		//populate country options: Used ISO country code
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("IN", "India");
		countryOptions.put("AU", "Australia");
		countryOptions.put("CH", "China");
		countryOptions.put("GE", "Germany");
		countryOptions.put("US", "United States of America");
		
		operatingSystemsOptions = new LinkedHashMap<>();
		
		operatingSystemsOptions.put("Windows","Windows");
		operatingSystemsOptions.put("MacOS","MacOS");
		operatingSystemsOptions.put("Ubuntu","Ubuntu");
		operatingSystemsOptions.put("Linux","Linux");
		operatingSystemsOptions.put("Android","Android");		
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public LinkedHashMap<String, String> getOperatingSystemsOptions() {
		return operatingSystemsOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}	
}
