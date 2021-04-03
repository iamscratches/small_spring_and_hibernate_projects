package com.iamscratches.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamscratches.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// That's it ... no need to write any code LOL!
}
