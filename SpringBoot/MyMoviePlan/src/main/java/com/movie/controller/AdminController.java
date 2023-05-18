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
import com.movie.exception.AdminAlreadyExistsException;
import com.movie.exception.AdminNotFoundException;
import com.movie.exception.LoginException;
import com.movie.model.Admin;
import com.movie.service.AdminService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/movie")
@Validated
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/add/admin")
	public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin admin) throws Exception {
		String tempEmail = admin.getAdminEmail();
		if (tempEmail != null && !"".equals(tempEmail)) {
			Admin adminObj = service.getByEmail(tempEmail);
			if (adminObj != null) {
				throw new AdminAlreadyExistsException();
			}
		}
		Admin adminObj = null;
		adminObj = service.addAdmin(admin);
		return new ResponseEntity<>(adminObj, HttpStatus.CREATED);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/admin/{email}")
	public ResponseEntity<Admin> getByAdminEmail(@PathVariable("email") String email) throws Exception {
		Admin admin = service.getByEmail(email);
		if (admin == null) {
			throw new AdminNotFoundException();
		}
		return new ResponseEntity<>(admin, HttpStatus.FOUND);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/login")
	public ResponseEntity<Admin> getByAdminEmailAndPassword(@RequestBody Admin admin) throws Exception {
		String tempEmail = admin.getAdminEmail();
		String tempPass = admin.getAdminPassword();
		Admin adminObj = null;
		if (tempEmail != null && tempPass != null) {
			adminObj = service.getByEmailAndPassword(tempEmail, tempPass);
		}
		if (adminObj == null) {
			throw new LoginException();
		}
		return new ResponseEntity<>(adminObj, HttpStatus.FOUND);
	}
}
