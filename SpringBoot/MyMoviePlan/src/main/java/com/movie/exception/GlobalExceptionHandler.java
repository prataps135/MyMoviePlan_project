package com.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value=UserAlreadyExistsException.class)
	public ResponseEntity<Object> exception(UserAlreadyExistsException ex){
		return ResponseEntity<Object>("User already Exists in Database",HttpStatus.CONFLICT);
	}
}
