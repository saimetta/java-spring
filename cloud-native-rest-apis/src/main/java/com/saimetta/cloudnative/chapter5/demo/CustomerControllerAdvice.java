package com.saimetta.cloudnative.chapter5.demo;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class CustomerControllerAdvice {
	
	@ExceptionHandler
	ResponseEntity<CustomResponse> notFoundException(CustomerNotFoundException e) {
		return error(e, HttpStatus.NOT_FOUND,e.getId().toString());
	}
	
	
	private <E extends Exception> ResponseEntity<CustomResponse> error(E error, HttpStatus httpStatus, String logMessage) {
		String message = Optional.of(error.getMessage()).orElse(error.getClass().getSimpleName());
		CustomResponse response = new CustomResponse();
		response.setHttpCode(httpStatus.value());
		response.setMessage(message);
		response.setResult(error.getStackTrace());
	
		return new ResponseEntity<>(response, httpStatus);
	}
	
}
