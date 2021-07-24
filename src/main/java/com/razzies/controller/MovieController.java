package com.razzies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razzies.model.Movie;
import com.razzies.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {

	@Autowired
	MovieService service;

	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

}
