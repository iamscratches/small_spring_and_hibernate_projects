package com.iamscratches.springboot.cruddemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iamscratches.springboot.cruddemo.dao.EmployeeDAO;
import com.iamscratches.springboot.cruddemo.entity.Employee;
import com.iamscratches.springboot.cruddemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public boolean save(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public boolean deleteById(int id) {
		return employeeDAO.deleteById(id);
	}

}
