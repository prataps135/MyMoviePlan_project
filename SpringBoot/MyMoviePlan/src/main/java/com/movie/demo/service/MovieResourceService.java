package com.movie.demo.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.movie.demo.model.MovieResource;

@Component
public interface MovieResourceService {
	List<MovieResource> getAllGenre();
}
