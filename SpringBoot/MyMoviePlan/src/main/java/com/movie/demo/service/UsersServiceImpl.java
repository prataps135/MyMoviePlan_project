package com.movie.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.demo.model.Users;
import com.movie.demo.repository.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Override
	public Users addUser(Users user) {
		Users usertemp = usersRepo.save(user);
		return usertemp;
	}

	@Override
	public Users getByEmail(String email) {
		Users user = usersRepo.findByUserEmail(email);
		return user;
	}

	@Override
	public Users getByEmailAndPassword(String email, String password) {
		Users user = usersRepo.findByUserEmailAndUserPassword(email, password);
		return user;
	}
	
}