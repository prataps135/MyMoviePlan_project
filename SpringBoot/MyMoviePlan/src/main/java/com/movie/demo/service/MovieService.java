package com.movie.demo.service;

import org.springframework.stereotype.Component;
import com.movie.demo.model.Movie;

@Component
public interface MovieService {
	Movie addMovie(Movie movie);
	Movie getByName(String name);
	Iterable<Movie> getMovieList();
}
