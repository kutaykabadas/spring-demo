package com.example.validationdemo.validation;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String	coursePrefix;

	private Pattern	pattern;

	@Override
	public void initialize(CourseCode courseCode) {
		this.coursePrefix = courseCode.value().toLowerCase();

		// Unnecessary and defeats the purpose but nice to have this as an example.
		this.pattern = Pattern.compile(courseCode.pattern());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		return value.toLowerCase().startsWith(coursePrefix) && this.pattern.matcher(value).matches();
	}

}
