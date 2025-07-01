package com.example.mycoolapp.dao;

import java.util.List;

import com.example.mycoolapp.entity.student.Student;

public interface StudentDAO {
	/**
	 * Create
	 * 
	 * @param student
	 */
	void save(Student student);

	/**
	 * Read
	 * 
	 * @param id
	 * @return
	 */
	Student findById(int id);

	/**
	 * Update
	 * 
	 * @param student
	 */
	void updateStudent(Student student);

	/**
	 * Delete
	 * student instance must found at the @Transactional method
	 * 
	 * @param student
	 */
	void deleteStudent(int id);

	/**
	 * Find all
	 * 
	 * @return
	 */
	List<Student> findAll();

	/**
	 * Find by last name
	 * 
	 * @return
	 */
	List<Student> findByLastName(String lastName);

}
