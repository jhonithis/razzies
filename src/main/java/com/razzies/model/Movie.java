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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
	
	@OneToMany(mappedBy="movie", cascade = CascadeType.ALL)
	private List<Studio> studios;
	
	@OneToMany(mappedBy="movie", cascade = CascadeType.ALL)
	private List<Producer> producers;

}