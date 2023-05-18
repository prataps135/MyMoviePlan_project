package com.movie.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.movie.demo.model.Users;

@Repository
public interface UsersRepo extends CrudRepository<Users,Integer>{
	Users findByUserEmail(String email);
	Users findByUserEmailAndUserPassword(String email, String password);
}