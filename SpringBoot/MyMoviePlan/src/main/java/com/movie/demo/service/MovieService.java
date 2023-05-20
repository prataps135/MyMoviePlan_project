package com.movie.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import com.movie.demo.model.Movie;

@Component
public interface MovieService {
	Movie addMovie(Movie movie);
	Movie getByName(String name);
	Movie getById(int id);
//	Iterable<Movie> getMovieList();
	List<Movie> getAllMovies();
	Movie updateMovie(int id, Movie movie);
	List<Movie> deleteMovieById(int id) throws Exception;
}
