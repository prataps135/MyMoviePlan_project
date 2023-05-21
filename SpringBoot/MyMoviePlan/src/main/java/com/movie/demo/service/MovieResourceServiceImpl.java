package com.movie.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.demo.model.MovieResource;
import com.movie.demo.repository.MovieResourceRepo;

@Service
public class MovieResourceServiceImpl implements MovieResourceService{

	@Autowired
	MovieResourceRepo repo;
		
	@Override
	public List<MovieResource> getAllGenre() {
		List<MovieResource> li = new ArrayList<>();
		li = repo.findAll().stream().collect(Collectors.toList());
		return li;
	}

}
