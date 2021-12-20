package com.springboot.jpa.h2.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.jpa.h2.entity.EntityErrorClass;

@ControllerAdvice
@ResponseStatus
public class ResponseEntityErrorExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = DepartmentNotFoundException.class)
	public ResponseEntity<EntityErrorClass> departmentNotFoundException(DepartmentNotFoundException exception) {
		
		EntityErrorClass message = new EntityErrorClass(HttpStatus.NOT_FOUND, exception.getMessage());
		
		return ResponseEntity.status(message.getStatusCode()).body(message);
	}

}
