package com.movie.demo.service;

import java.util.ArrayList;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.demo.model.Movie;
import com.movie.demo.repository.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public Movie addMovie(Movie movie) {
		Movie tempMovie = movieRepo.save(movie);
		return tempMovie;
	}

	@Override
	public Movie getByName(String name) {
		Movie movie = movieRepo.findByMovieName(name);
		return movie;
	}

	@Override
	public Iterable<Movie> getMovieList() {
		return movieRepo.findAll();
	}

}