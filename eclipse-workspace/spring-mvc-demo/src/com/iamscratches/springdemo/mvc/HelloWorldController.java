package com.iamscratches.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")// controller level request mapping
public class HelloWorldController {
	
	//need a Controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form 
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processFormNew(HttpServletRequest request, Model model) {
		
		//read the request parameter from html form
		String theName = request.getParameter("studentName");
		
		//Convert the data to all upper case
		theName = "Yo " + theName.toUpperCase();
		
		//add message to the model
		model.addAttribute("message", theName);
		
		return "helloworld";
	}
	
	//Binding request params
	@RequestMapping("/processFormVersionThree")
	public String processFormThree(@RequestParam("studentName") String theName, Model model) {		
	
		//Convert the data to all upper case
		theName = "Hey My friend from v3! " + theName.toUpperCase();
		
		//add message to the model
		model.addAttribute("message", theName);
		
		return "helloworld";
	}

}
/* 8080 port blocked:
 * Open command prompt as administrator
 * netstat -ano | findstr 8080
 * taskkill /F /pid 1088
 */
