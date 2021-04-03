package com.iamscratches.springboot.thymeleafDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iamscratches.springboot.thymeleafDemo.entity.Employee;
import com.iamscratches.springboot.thymeleafDemo.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
//	//load employee data
//	private List<Employee> employees;
//	
//	@PostConstruct
//	private void loadData() {
//		
//		//create employees
//		Employee employee1 = new Employee("Subhankar", "Bhattacharyya", "subhankar.bhattacharyya@oracle.com");
//		Employee employee2 = new Employee("Aaryan", "Saha", "aarayan.saha@oracle.com");
//		Employee employee3 = new Employee("Richik", "Nandy", "richik.nandy@oracle.com");
//		Employee employee4 = new Employee("Gopal", "Kumar", "goapl.kumar@oracle.com");
//		Employee employee5 = new Employee("Priyadarshi", "Mukherjee", "priyadarshi.mukherjee@oracle.com");
//		Employee employee6 = new Employee("Subham", "Kumar", "subham.kumar@oracle.com");
//		
//		//create the list
//		employees = new ArrayList<Employee>();
//		
//		//add to the list
//		employees.add(employee1);
//		employees.add(employee2);
//		employees.add(employee3);
//		employees.add(employee4);
//		employees.add(employee5);
//		employees.add(employee6);
//	}
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;	
	}
	
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		//get the employees from the database
		List<Employee> employees = employeeService.findAll();
		
		//add to spring model
		model.addAttribute("employees",employees);		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//create model attribute to bind form data
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int id, Model model) {
		//get the employee
		Employee employee = employeeService.findById(id);
		
		//set the employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		
		//send over to our form 
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId")int id, Model model) {
		//delete the employee
		employeeService.deleteById(id);
		
		//redirect to /employees/list
		return "redirect:/employees/list";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		//save the employee
		employeeService.save(employee);
		
		//use a redirect to prevent duplicate submission
		return "redirect:/employees/list";
	}
}
