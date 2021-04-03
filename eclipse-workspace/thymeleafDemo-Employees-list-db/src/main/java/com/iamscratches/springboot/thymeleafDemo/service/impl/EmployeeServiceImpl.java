package com.iamscratches.springboot.thymeleafDemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamscratches.springboot.thymeleafDemo.dao.EmployeeRepository;
import com.iamscratches.springboot.thymeleafDemo.entity.Employee;
import com.iamscratches.springboot.thymeleafDemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
		}
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public boolean deleteById(int id) {
		employeeRepository.deleteById(id);
		return true;
	}

}
