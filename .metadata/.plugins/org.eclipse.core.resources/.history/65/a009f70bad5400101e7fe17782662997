package com.example.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAORepository") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}
}
