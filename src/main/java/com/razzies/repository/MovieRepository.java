package com.razzies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razzies.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  
	List<Movie> findByWinner(boolean winner);
	
	List<Movie> findByTitleContaining(String title);
	
}
