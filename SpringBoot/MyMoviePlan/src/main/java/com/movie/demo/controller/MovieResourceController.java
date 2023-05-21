package com.movie.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movie.demo.model.MovieResource;
import com.movie.demo.service.MovieResourceService;

@RestController
public class MovieResourceController {
	
	@Autowired
	MovieResourceService service;
	
	@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
	@GetMapping(value="/movie/resource")
	public ResponseEntity<List<MovieResource>> getAllGenre(){
		List<MovieResource> li = new ArrayList<>();
		li = service.getAllGenre();
		return new ResponseEntity<>(li,HttpStatus.OK);
	}
	
}
