package com.movie.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping(value = "/api")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PostMapping(value = "/add/movie")
	public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) throws Exception {
		String movieName = movie.getMovieName();
		if (movieName != null && !"".equals(movieName)) {
			Movie tempMovie = movieService.getByName(movieName);
			if (tempMovie != null) {
				throw new MovieAlreadyExistsException();
			}
		}
		Movie movieObj = null;
		movieObj = movieService.addMovie(movie);
		return new ResponseEntity<>(movieObj, HttpStatus.CREATED);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/movie/name/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable String name) throws Exception {
		Movie movie = movieService.getByName(name);
		if (movie == null)
			throw new MovieNotFoundException();
		return new ResponseEntity<>(movie, HttpStatus.FOUND);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/movie/all")
	public ResponseEntity<Iterable<Movie>> getAllMovies() throws Exception {
		Iterable<Movie> movie = movieService.getAllMovies();
		return new ResponseEntity<>(movie, HttpStatus.FOUND);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value = "/movie/id/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable("id") int id) throws Exception {
		Movie movie = movieService.getById(id);
		if (movie == null)
			throw new MovieNotFoundException();
		else
			return new ResponseEntity<>(movie, HttpStatus.FOUND);
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@DeleteMapping(value = "/movie/delete/{id}")
	public ResponseEntity<List<Movie>> deleteMovie(@PathVariable("id") int id) throws Exception {
		Movie movie = null;
		movie = movieService.getById(id);
		if (movie == null)
			throw new MovieNotFoundException();
		else {
			List<Movie> li = new ArrayList<>();
			li = movieService.deleteMovieById(id);
			return new ResponseEntity<>(li, HttpStatus.OK);
		}
	}

	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@PutMapping(value = "movie/update/{id}")
	public ResponseEntity<Movie> updateMovieById(@PathVariable("id") int id, @RequestBody Movie movie)
			throws Exception {
		Movie tempMovie = null;
		tempMovie = movieService.updateMovie(id, movie);
		if (movie == null)
			throw new MovieNotFoundException();
		else
			return new ResponseEntity<>(tempMovie, HttpStatus.OK);
	}

}
