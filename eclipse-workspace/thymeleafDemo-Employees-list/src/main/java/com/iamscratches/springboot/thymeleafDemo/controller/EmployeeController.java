package com.iamscratches.springboot.thymeleafDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iamscratches.springboot.thymeleafDemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	//load employee data
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		
		//create employees
		Employee employee1 = new Employee(1, "Subhankar", "Bhattacharyya", "subhankar.bhattacharyya@oracle.com");
		Employee employee2 = new Employee(2, "Aaryan", "Saha", "aarayan.saha@oracle.com");
		Employee employee3 = new Employee(3, "Richik", "Nandy", "richik.nandy@oracle.com");
		Employee employee4 = new Employee(4, "Gopal", "Kumar", "goapl.kumar@oracle.com");
		Employee employee5 = new Employee(5, "Priyadarshi", "Mukherjee", "priyadarshi.mukherjee@oracle.com");
		Employee employee6 = new Employee(6, "Subham", "Kumar", "subham.kumar@oracle.com");
		
		//create the list
		employees = new ArrayList<Employee>();
		
		//add to the list
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
	}
	
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model model) {
		//add to spring model
		model.addAttribute("employees",employees);		
		return "list-employees";
	}
}
