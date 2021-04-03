package com.iamscratches.springboot.cruddemo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iamscratches.springboot.cruddemo.dao.EmployeeDAO;
import com.iamscratches.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;		 
	}

	@Override
	public List<Employee> findAll() {
		
		//create a query 
		Query query = entityManager.createQuery("from Employee");
		
		//execute query and get result list
		List<Employee> employees = query.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		//get employee
		Employee employee = entityManager.find(Employee.class, id);
		
		//return employee
		return employee;
	}

	@Override
	public boolean save(Employee employee) {
		//save or update the employee
		Employee dbEmployee = entityManager.merge(employee);
		
		//update with id from db ... so we can get generated id for save/insert
		employee.setId(dbEmployee.getId());
		return true;
	}

	@Override
	public boolean deleteById(int id) {
//		//find employee
//		Employee employee = entityManager.find(Employee.class, id);
//		
//		//delete object with primary key
//		entityManager.remove(employee);
		
		//We can also use Query language for this
		Query query = entityManager.createQuery("delete from Employee e where e.id=:employeeId");
		query.setParameter("employeeId", id);	
		query.executeUpdate();
		
		return true;
	}

}
