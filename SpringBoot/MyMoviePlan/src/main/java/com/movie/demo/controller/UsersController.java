package com.movie.demo.controller;

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
import com.movie.demo.exception.LoginException;
import com.movie.demo.exception.UserAlreadyExistsException;
import com.movie.demo.exception.UserNotFoundException;
import com.movie.demo.model.Users;
import com.movie.demo.service.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
@Validated
public class UsersController {

	@Autowired
	private UsersService usersService;

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/add/user")
	public ResponseEntity<Users> addUser(@Valid @RequestBody Users user) throws Exception {
		String tempEmail = user.getUserEmail();
		if (tempEmail != null && !"".equals(tempEmail)) {
			Users userObj = usersService.getByEmail(tempEmail);
			if (userObj != null) {
				throw new UserAlreadyExistsException();
			}
		}
		Users usrObj = null;
		usrObj = usersService.addUser(user);
		return new ResponseEntity<>(usrObj, HttpStatus.CREATED);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/user/{email}")
	public ResponseEntity<Users> getByUserEmail(@PathVariable("email") String email) throws Exception {
		Users user = usersService.getByEmail(email);
		if (user == null) {
			throw new UserNotFoundException();
		}
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/user/login")
	public ResponseEntity<Users> getByUserEmailAndPassword(@RequestBody Users user) throws Exception {
		String tempEmail = user.getUserEmail();
		String tempPass = user.getUserPassword();
		Users usObj = null;
		if (tempEmail != null && tempPass != null) {
			usObj = usersService.getByEmailAndPassword(tempEmail, tempPass);
		}
		if (usObj == null) {
			throw new LoginException();
		}
		return new ResponseEntity<>(usObj, HttpStatus.FOUND);
	}
}