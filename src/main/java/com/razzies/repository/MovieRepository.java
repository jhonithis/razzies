package com.razzies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razzies.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
