package com.razzies.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie implements Serializable{

	private static final long serialVersionUID = 7014011614993525414L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String title;
	
	@NotNull
	private int year;

	@NotNull
	private boolean winner;
	
	@JsonIgnore
	@OneToMany(mappedBy="movie", cascade = CascadeType.ALL)
	private List<Studio> studios;
	
	@JsonIgnore
	@OneToMany(mappedBy="movie", cascade = CascadeType.ALL)
	private List<Producer> producers;
	
	public Movie() {}

	public Movie(@NotNull String title, @NotNull int year, @NotNull boolean winner) {
		super();
		this.title = title;
		this.year = year;
		this.winner = winner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public List<Studio> getStudios() {
		return studios;
	}

	public void setStudios(List<Studio> studios) {
		this.studios = studios;
	}

	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}

}