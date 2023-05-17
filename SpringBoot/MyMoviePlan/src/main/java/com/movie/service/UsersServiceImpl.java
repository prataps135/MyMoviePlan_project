package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.model.Users;
import com.movie.repository.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UsersRepo repo;
	
	@Override
	public Users addUser(Users user) {
//		Users usertemp = repo.save(user);
//		return usertemp;
		return repo.save(user);
	}

	@Override
	public Users getByEmail(String emial) {
		Users user = repo.findByEmail(emial);
		return user;
	}

	@Override
	public Users getByEmailAndPassword(String email, String password) {
		Users user = repo.findByEmailAndPassword(email, password);
		return user;
	}
	
}
