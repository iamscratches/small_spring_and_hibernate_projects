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
