package com.iamscratches.springboot.cruddemo.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iamscratches.springboot.cruddemo.dao.EmployeeDAO;
import com.iamscratches.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		 this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get result lists
		List<Employee> employees = theQuery.getResultList();
		
		//return the results		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee employee = currentSession.get(Employee.class, id);
		
		//return the employee
		return employee;
	}

	@Override
	public boolean save(Employee employee) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save the employee
		currentSession.saveOrUpdate(employee);
		System.out.println(employee);
		
		//return success
		return true;
	}

	@Override
	public boolean deleteById(int id) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete the employee
		Employee employee = currentSession.get(Employee.class, id);
		currentSession.delete(employee);
		
		//return success
		return true;
	}
}
