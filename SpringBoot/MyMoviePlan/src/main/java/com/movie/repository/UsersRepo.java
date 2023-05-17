package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.movie.model.Users;

@Repository
public interface UsersRepo extends CrudRepository<Integer, Users>{
	Users findByEmail(String email);
	Users findByEmailAndPassword(String email, String password);
}
