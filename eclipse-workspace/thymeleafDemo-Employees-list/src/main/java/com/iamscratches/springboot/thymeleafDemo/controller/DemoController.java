package com.iamscratches.springboot.thymeleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	// create mapping for "/hello"
	@GetMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("Date", new java.util.Date());
		return "hello-world";
	}
}
