package com.movie.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.demo.exception.DeleteMovieException;
import com.movie.demo.model.Movie;
import com.movie.demo.repository.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {

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

//	@Override
//	public Iterable<Movie> getMovieList() {
//		return movieRepo.findAll();
//	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public Movie updateMovie(int id, Movie movie) {
		if (movieRepo.findById(id).isPresent()) {
			Movie tempMovie = movieRepo.findById(id).get();
			tempMovie.setMovieDescription(movie.getMovieDescription());
			tempMovie.setMovieName(movie.getMovieName());
			tempMovie.setTicketValue(movie.getTicketValue());
			return movieRepo.save(tempMovie);
		} else {
			return null;
		}

	}

	@Override
	public Movie getById(int id) {
		 return movieRepo.findById(id).get();
	}

	@Override
	public List<Movie> deleteMovieById(int id) throws Exception{
		List<Movie> li = new ArrayList<>();
		if (movieRepo.findById(id).isPresent()) {
			movieRepo.deleteById(id);
			li = movieRepo.findAll().stream().collect(Collectors.toList());
			return li;
		} else {
			throw new DeleteMovieException();
		}
	}

}