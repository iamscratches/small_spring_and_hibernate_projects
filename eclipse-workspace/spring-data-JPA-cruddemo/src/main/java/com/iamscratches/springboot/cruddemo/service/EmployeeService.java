package com.iamscratches.springboot.cruddemo.service;

import java.util.List;

import com.iamscratches.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee save(Employee employee);
	
	public boolean deleteById(int id);
	
}
