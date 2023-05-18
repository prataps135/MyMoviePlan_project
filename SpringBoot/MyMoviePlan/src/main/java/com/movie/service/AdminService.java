package com.movie.service;

import org.springframework.stereotype.Component;
import com.movie.model.Admin;

@Component
public interface AdminService {
	Admin addAdmin(Admin admin);
	Admin getByEmail(String email);
	Admin getByEmailAndPassword(String email, String password);
}
