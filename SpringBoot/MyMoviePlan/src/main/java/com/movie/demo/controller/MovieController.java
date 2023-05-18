package com.movie.demo.controller;

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
import com.movie.demo.exception.MovieAlreadyExistsException;
import com.movie.demo.exception.MovieNotFoundException;
import com.movie.demo.model.Movie;
import com.movie.demo.service.MovieService;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping(value="/api")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value="/add/movie")
	public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) throws Exception{
		String movieName = movie.getMovieName();
		if(movieName != null && !"".equals(movieName)) {
			Movie tempMovie = movieService.getByName(movieName);
			if(tempMovie != null) {
				throw new MovieAlreadyExistsException();
			}
		}
		Movie movieObj = null;
		movieObj = movieService.addMovie(movie);
		return new ResponseEntity<>(movieObj, HttpStatus.CREATED);
	}
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value="/movie/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable String name) throws Exception{
		Movie movie = movieService.getByName(name);
		if(movie == null)
			throw new MovieNotFoundException();
		return new ResponseEntity<>(movie,HttpStatus.FOUND);
	}
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value="/movie/all")
	public ResponseEntity<Iterable<Movie>> getAllMovies() throws Exception{
		Iterable<Movie> movie = movieService.getMovieList();
		return new ResponseEntity<>(movie,HttpStatus.FOUND);
	}

}
