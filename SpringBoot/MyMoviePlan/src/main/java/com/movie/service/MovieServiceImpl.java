package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.model.Movie;
import com.movie.repository.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepo repo;
	
	@Override
	public Movie addMovie(Movie movie) {
		Movie tempMovie = repo.save(movie);
		return tempMovie;
	}

	@Override
	public Movie getByName(String name) {
		Movie movie = repo.findByName(name);
		return movie;
	}

}
