package com.movie.demo.service;

import org.springframework.stereotype.Component;
import com.movie.demo.model.Admin;

@Component
public interface AdminService {
	Admin addAdmin(Admin admin);
	Admin getByEmail(String email);
	Admin getByEmailAndPassword(String email, String password);
}
