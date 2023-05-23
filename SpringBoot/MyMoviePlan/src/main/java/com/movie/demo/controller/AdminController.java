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
import com.movie.demo.exception.AdminAlreadyExistsException;
import com.movie.demo.exception.AdminNotFoundException;
import com.movie.demo.exception.LoginException;
import com.movie.demo.model.Admin;
import com.movie.demo.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
@Validated
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/add/admin")
	public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin admin) throws Exception {
		String tempEmail = admin.getAdminEmail();
		if (tempEmail != null && !"".equals(tempEmail)) {
			Admin adminObj = adminService.getByEmail(tempEmail);
			if (adminObj != null) {
				throw new AdminAlreadyExistsException();
			}
		}
		Admin adminObj = null;
		adminObj = adminService.addAdmin(admin);
		return new ResponseEntity<Admin>(adminObj, HttpStatus.CREATED);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/admin/{email}")
	public ResponseEntity<Admin> getByAdminEmail(@PathVariable("email") String email) throws Exception {
		Admin admin = adminService.getByEmail(email);
		if (admin == null) {
			throw new AdminNotFoundException();
		} 
		return new ResponseEntity<Admin>(admin,HttpStatus.FOUND);
		
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/admin/login")
	public ResponseEntity<Admin> getByAdminEmailAndPassword(@RequestBody Admin admin) throws Exception {
		String tempEmail = admin.getAdminEmail();
		String tempPass = admin.getAdminPassword();
		Admin adminObj = null;
		if (tempEmail != null && tempPass != null) {
			adminObj = adminService.getByEmailAndPassword(tempEmail, tempPass);
		}
		if (adminObj == null) {
			throw new LoginException();
		}
		return new ResponseEntity<Admin>(adminObj, HttpStatus.FOUND);
	}
}
