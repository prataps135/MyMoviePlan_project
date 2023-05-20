package com.movie.demo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.movie.demo.model.Movie;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer>{
	Movie findByMovieName(String name);
	List<Movie> findAll();
}
