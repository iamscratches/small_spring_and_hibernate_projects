package com.iamscratches.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Value("#{countryOptions2}") 
	private Map<String, String> countryOptions2;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//Create a new student object
		Student theStudent = new Student();
		
		//add student object to the code
		theModel.addAttribute("student",theStudent);
		
		// add the country options to the model 
	    theModel.addAttribute("theCountryOptions2", countryOptions2); 

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log the input-data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		System.out.println("Country: " + theStudent.getCountry());
		System.out.println("Language: " + theStudent.getFavouriteLanguage());
		
		return "student-confimation";
	}
	
	public Map<String, String> getCountryOptions2() {
		for(int i=0; i<countryOptions2.size();i++) {
			System.out.println(countryOptions2.get("IN"));
		}
		
		return countryOptions2;
	}
}
