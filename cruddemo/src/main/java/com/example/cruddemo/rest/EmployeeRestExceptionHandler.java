package com.example.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.cruddemo.exc.EmployeeErrorResponse;
import com.example.cruddemo.exc.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc) {
		EmployeeErrorResponse EmployeeErrorResponse = new EmployeeErrorResponse();

		EmployeeErrorResponse.setMessage(exc.getMessage());
		EmployeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		EmployeeErrorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(EmployeeErrorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
		EmployeeErrorResponse EmployeeErrorResponse = new EmployeeErrorResponse();

		EmployeeErrorResponse.setMessage(exc.getMessage());
		EmployeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		EmployeeErrorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(EmployeeErrorResponse, HttpStatus.BAD_REQUEST);
	}
}
