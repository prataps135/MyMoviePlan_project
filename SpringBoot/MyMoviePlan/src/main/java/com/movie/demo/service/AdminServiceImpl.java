package com.movie.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.demo.model.Admin;
import com.movie.demo.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Admin addAdmin(Admin admin) {
		Admin tempAdmin = adminRepo.save(admin);
		return tempAdmin;
	}
	
	@Override
	public Admin getByEmail(String email) {
		Admin admin = adminRepo.findByAdminEmail(email);
		return admin;
	}

	@Override
	public Admin getByEmailAndPassword(String email, String password) {
		Admin admin = adminRepo.findByAdminEmailAndAdminPassword(email, password);
		return admin;
	}
}
