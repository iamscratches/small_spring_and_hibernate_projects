package com.iamscratches.springboot.cruddemo.dao;

import java.util.List;

import com.iamscratches.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public boolean save(Employee employee);
	
	public boolean deleteById(int id);
}
