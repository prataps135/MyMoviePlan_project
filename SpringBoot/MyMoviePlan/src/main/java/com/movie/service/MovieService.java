package com.movie.service;

import org.springframework.stereotype.Component;
import com.movie.model.Movie;

@Component
public interface MovieService {
	Movie addMovie(Movie movie);
	Movie getByName(String name);
}