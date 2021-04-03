package com.iamscratches.springboot.thymeleafDemo.service;

import java.util.List;

import com.iamscratches.springboot.thymeleafDemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee save(Employee employee);
	
	public boolean deleteById(int id);
}
