package com.razzies.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Producer implements Serializable{

	private static final long serialVersionUID = 8323579021507580212L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;
	
	@ManyToOne
	@NotNull
	private Movie movie;
	
	public Producer() {}
	
	public Producer(@NotNull String name, @NotNull Movie movie) {
		super();
		this.name = name;
		this.movie = movie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}