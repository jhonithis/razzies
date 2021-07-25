package com.razzies.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.razzies.controller.MovieController;
import com.razzies.model.Movie;
import com.razzies.service.MovieService;

@SpringBootTest
class LaunchApplicationTests {

	@Autowired
	MovieService movieService;

	@Autowired
	private MovieController controller;
	
	@Test
	void checkMoviesInsertedInDatabaseByFileCSV() {
		List<Movie> movies = movieService.getAll();
		assertThat(movies).isNotNull();
		assertThat(movies).isNotEmpty();
		assertThat(movies.size() > 0);
	}

	@Test
	public void checkInjectionMovieController() {
		assertThat(controller).isNotNull();
	}

}
