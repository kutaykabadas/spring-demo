package com.example.validationdemo.model;

import com.example.validationdemo.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
	private String	firstName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Pattern(regexp = "^[\\p{L}]+$", message = "only letters are allowed")
	private String	lastName;;

	@Min(value = 0, message = "must be greater than 0")
	@Max(value = 10, message = "must be less than 10")
	@NotNull(message = "is required")
	private Integer	freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	@NotNull(message = "is required")
	private String	postalCode;

	// @Pattern(regexp = "^ABC\\d{3}$", message =
	// "{patternMismatch.customer.courseCode}")
	@CourseCode()
	@NotNull(message = "is required")
	private String	courseCode;

	public Customer() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
