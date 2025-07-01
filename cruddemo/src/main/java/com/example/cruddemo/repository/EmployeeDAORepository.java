package com.example.cruddemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAORepository implements EmployeeDAO {
	private EntityManager entityManager;

	@Autowired
	public EmployeeDAORepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	// insert or update
	// if id == 0 insert else update
	@Override
	public Employee save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		
		return dbEmployee;
	}

	@Override
	public void deleteById(int id) {
		Employee employee = entityManager.find(Employee.class, id);

		entityManager.remove(employee);
	}

}
