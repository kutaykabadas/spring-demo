package com.example.restapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapp.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> theStudents;

	@PostConstruct
	public void postConstruct() {
		theStudents = new ArrayList<>();

		theStudents.add(new Student("peter", "parker"));
		theStudents.add(new Student("marry", "jane"));
		theStudents.add(new Student("eddy", "brock"));
	}

	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		if (studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("The student id not found - " + studentId);
		}

		return theStudents.get(studentId);
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}

}
