package com.movie.demo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.movie.demo.model.MovieResource;

@Repository
public interface MovieResourceRepo extends CrudRepository<MovieResource, String>{
	List<MovieResource> findAll();
}
