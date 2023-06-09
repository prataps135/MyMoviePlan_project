package com.movie.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = UserAlreadyExistsException.class)
	public ResponseEntity<Object> exception(UserAlreadyExistsException ex) {
		return new ResponseEntity<Object>("User already Exists in Database", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException ex) {
		return new ResponseEntity<Object>("User not Found in Database", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = LoginException.class)
	public ResponseEntity<Object> exception(LoginException ex){
		return new ResponseEntity<>("Invalid Details",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = AdminAlreadyExistsException.class)
	public ResponseEntity<Object> exception(AdminAlreadyExistsException ex){
		return new ResponseEntity<>("Admin already Exists in Database",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = AdminNotFoundException.class)
	public ResponseEntity<Object> exception(AdminNotFoundException ex){
		return new ResponseEntity<>("Admin not found in Database",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = MovieNotFoundException.class)
	public ResponseEntity<Object> exception(MovieNotFoundException ex){
		return new ResponseEntity<>("Movie not found in DataBase",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = MovieAlreadyExistsException.class)
	public ResponseEntity<Object> exception(MovieAlreadyExistsException ex){
		return new ResponseEntity<>("Movie already Exists in Database",HttpStatus.CONFLICT);
	}
	
	public ResponseEntity<Object> exception(DeleteMovieException ex){
		return new ResponseEntity<>("Deletion is not Possible",HttpStatus.CONFLICT);
	}
}
