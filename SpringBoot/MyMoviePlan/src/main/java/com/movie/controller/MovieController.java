package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movie.exception.MovieAlreadyExistsException;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;
import com.movie.service.MovieService;
import jakarta.validation.Valid;

@RestController
@Validated
//@RequestMapping(value="/api/movie")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value="/add/movie")
	public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) throws Exception{
		String movieName = movie.getMovieName();
		if(movieName != null && !"".equals(movieName)) {
			Movie tempMovie = service.getByName(movieName);
			if(tempMovie != null) {
				throw new MovieAlreadyExistsException();
			}
		}
		Movie movieObj = null;
		movieObj = service.addMovie(movie);
		return new ResponseEntity<>(movieObj, HttpStatus.CREATED);
	}
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value="/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable String name) throws Exception{
		Movie movie = service.getByName(name);
		if(movie == null)
			throw new MovieNotFoundException();
		return new ResponseEntity<>(movie,HttpStatus.FOUND);
	}

}
