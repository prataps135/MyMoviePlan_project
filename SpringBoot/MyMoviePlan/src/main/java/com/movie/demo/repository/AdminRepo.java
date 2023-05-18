package com.movie.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.movie.demo.model.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Integer>{

	Admin findByAdminEmail(String email);
	Admin findByAdminEmailAndAdminPassword(String email, String password);
}