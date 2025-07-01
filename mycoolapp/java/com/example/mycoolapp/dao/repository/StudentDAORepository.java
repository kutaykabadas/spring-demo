package com.example.mycoolapp.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mycoolapp.dao.StudentDAO;
import com.example.mycoolapp.entity.student.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAORepository implements StudentDAO {
	private EntityManager entityManager;

	@Autowired
	public StudentDAORepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) throws EntityNotFoundException {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		Student student = findById(id);

		entityManager.remove(student);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student", Student.class);

		return typedQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> typedQuery = entityManager
				.createQuery("SELECT s FROM Student s WHERE s.lastName=:data", Student.class);

		typedQuery.setParameter("data", lastName);

		return typedQuery.getResultList();
	}

}
