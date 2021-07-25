package com.razzies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razzies.model.Movie;
import com.razzies.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Transactional
	public void saveMovies(List<Movie> movies) throws Exception {
		movies.forEach(movie -> movieRepository.save(movie));
	}
	
	public List<Movie> getAll() {
		return movieRepository.findAll();
	}
	
}
