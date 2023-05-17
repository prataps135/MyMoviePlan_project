package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.movie.exception.UserAlreadyExistsException;
import com.movie.model.Users;
import com.movie.service.UsersService;


@RestController
//@Validated
public class UsersController {
	
	@Autowired
	UsersService service;
	
//	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value="/addUser")
	public ResponseEntity<Users> addCustomer(@RequestBody Users users) throws Exception{
		String tempEmail = users.getUserEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			Users usersObj = service.getByEmail(tempEmail);
			if(usersObj != null) {
				throw new UserAlreadyExistsException();
			}
		}
		Users usObj = null;
		usObj = service.addUser(users);
		return new ResponseEntity<Users>(usObj, HttpStatus.CREATED);
	}
	
//	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
//	@GetMapping(value="/customer/{email}")
//	public ResponseEntity<Customer> getByCustomerEmail(@PathVariable("email") String email) throws Exception{
//		Customer customer = customerService.getByEmail(email);
//		if(customer == null) {
//			throw new CustomerNotFoundException();
//		}
//		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
//	}
//	
//	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
//	@PostMapping(value="/login")
//	public ResponseEntity<Customer> getByEmailAndPassword(@RequestBody Customer customer) throws Exception {
//		String tempEmail = customer.getEmail();
//		String tempPass = customer.getPassword();
//		Customer customerObj = null;
//		if (tempEmail != null && tempPass != null) {
//			customerObj  = customerService.getByEmailAndPassword(tempEmail, tempPass);			
//		}
//		if (customerObj == null) {
//			throw new LoginException();
//		}
//		return new ResponseEntity<Customer>(customerObj, HttpStatus.OK);
//	}
}
