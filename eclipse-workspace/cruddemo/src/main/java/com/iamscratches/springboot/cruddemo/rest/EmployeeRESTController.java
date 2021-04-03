package com.iamscratches.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamscratches.springboot.cruddemo.dao.EmployeeDAO;
import com.iamscratches.springboot.cruddemo.entity.Employee;
import com.iamscratches.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

	private EmployeeService employeeService;
	
	//quick and dirty: inject employee dao
	@Autowired
	public EmployeeRESTController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if(employee==null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return employee;
	}
	
	//adding mapping for POST /employees - add a new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		// also just in case they pass an id in JSON... set id to 0
		// this is to force a save of new item... instead of update
		
		employee.setId(0);		
		employeeService.save(employee);
		
		return employee;
	}
	
	// add mapping for PUT /employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public boolean deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		if(tempEmployee==null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return employeeService.deleteById(employeeId);		
	}
}
