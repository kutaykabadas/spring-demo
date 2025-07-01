package com.example.mycoolapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.mycoolapp.dao.StudentDAO;
import com.example.mycoolapp.entity.student.Student;

@SpringBootApplication(scanBasePackages = { "com.example.util", "com.example.mycoolapp" })
public class MyCoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoolAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@Qualifier("studentDAORepository") StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// findStudent(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// findAllStudent(studentDAO);

			// findByLastName(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 4;

		studentDAO.deleteStudent(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 2;

		Student student = studentDAO.findById(id);
		System.out.println(student.getFirstName());

		student.setFirstName(student.getFirstName().toUpperCase());

		studentDAO.updateStudent(student);

		System.out.println(student.getFirstName());
	}

	private void findByLastName(StudentDAO studentDAO) {
		String lastName = "Parker";

		List<Student> theStudents = studentDAO.findByLastName(lastName);

		for (Student student : theStudents) {
			System.out.println(student.toString());
		}
	}

	private void findAllStudent(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		int i = 0;
		for (Student student : theStudents) {
			i++;
			System.out.println(student.toString());
		}

		System.out.println("Total entries: " + i);
	}

	private void findStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);

		System.out.println(student.getFirstName());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student object");

		Student student = new Student("Peter", "Parker", "peter@parker.com");

		studentDAO.save(student);

		System.out.println(student.getId());
	}

}
