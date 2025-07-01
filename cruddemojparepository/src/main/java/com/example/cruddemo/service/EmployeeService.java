package com.example.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddemo.dao.EmployeeRepository;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.exc.EmployeeNotFoundException;

@Service
public class EmployeeService implements IEmployeeService {
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);

		if (!result.isPresent()) {
			throw new EmployeeNotFoundException("Employee id not found: " + id);
		}

		return result.get();
	}

	// JPA Repository provides @Transactional
	// @Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	// JPA Repository provides @Transactional
	// @Transactional
	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
