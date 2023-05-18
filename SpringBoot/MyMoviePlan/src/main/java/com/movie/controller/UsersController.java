package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movie.exception.LoginException;
import com.movie.exception.UserAlreadyExistsException;
import com.movie.exception.UserNotFoundException;
import com.movie.model.Users;
import com.movie.service.UsersService;
import jakarta.validation.Valid;

@RestController
//@RequestMapping(value = "/movie")
@Validated
public class UsersController {

	@Autowired
	private UsersService service;

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/add/user")
	public ResponseEntity<Users> addUser(@Valid @RequestBody Users user) throws Exception {
		String tempEmail = user.getUserEmail();
		if (tempEmail != null && !"".equals(tempEmail)) {
			Users userObj = service.getByEmail(tempEmail);
			if (userObj != null) {
				throw new UserAlreadyExistsException();
			}
		}
		Users usrObj = null;
		usrObj = service.addUser(user);
		return new ResponseEntity<>(usrObj, HttpStatus.CREATED);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/user/{email}")
	public ResponseEntity<Users> getByUserEmail(@PathVariable("email") String email) throws Exception {
		Users user = service.getByEmail(email);
		if (user == null) {
			throw new UserNotFoundException();
		}
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/login")
	public ResponseEntity<Users> getByUserEmailAndPassword(@RequestBody Users user) throws Exception {
		String tempEmail = user.getUserEmail();
		String tempPass = user.getUserPassword();
		Users usObj = null;
		if (tempEmail != null && tempPass != null) {
			usObj = service.getByEmailAndPassword(tempEmail, tempPass);
		}
		if (usObj == null) {
			throw new LoginException();
		}
		return new ResponseEntity<>(usObj, HttpStatus.FOUND);
	}
}