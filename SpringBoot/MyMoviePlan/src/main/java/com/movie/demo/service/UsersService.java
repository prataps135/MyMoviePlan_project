package com.movie.demo.service;

import org.springframework.stereotype.Component;
import com.movie.demo.model.Users;

@Component
public interface UsersService {
	Users addUser(Users user);
	Users getByEmail(String emial);
	Users getByEmailAndPassword(String email, String password);
}

