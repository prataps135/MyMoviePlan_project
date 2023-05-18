package com.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.movie.model.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Integer>{

	Admin findByEmail(String email);
	Admin findByEmailAndPassword(String emial, String password);
}
