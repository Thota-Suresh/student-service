package com.student.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionController {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<Object> studentException(StudentException  message){
		return new ResponseEntity<>(message.getMessage(),HttpStatus.BAD_REQUEST);
	}
}