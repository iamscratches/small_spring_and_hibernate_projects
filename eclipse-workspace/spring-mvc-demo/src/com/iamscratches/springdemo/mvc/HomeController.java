package com.iamscratches.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	

}
/* Development process: Reading HTML form data
 * Create Controller class
 * Show HTML form
 * 	create controller method to show HTML form
 *  create view page for HTML form
 * Process HTML form
 * 	create controller method to process HTML form
 * 	develop view page for confirmation
 */
/*Development process: Add validation rule to customer class
 * Add validation rule to customer class
 * Display error message on HTML form
 * Perform validation in controller class
 * Update conformation page
 */
