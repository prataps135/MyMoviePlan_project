package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Admin;
import com.movie.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo repo;

	@Override
	public Admin addAdmin(Admin admin) {
		Admin tempAdmin = repo.save(admin);
		return tempAdmin;
	}
	
	@Override
	public Admin getByEmail(String email) {
		Admin admin = repo.findByEmail(email);
		return admin;
	}

	@Override
	public Admin getByEmailAndPassword(String email, String password) {
		Admin admin = repo.findByEmailAndPassword(email, password);
		return admin;
	}
}
