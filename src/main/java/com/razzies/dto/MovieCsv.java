package com.razzies.dto;

import com.opencsv.bean.CsvBindByPosition;

public class MovieCsv {

	@CsvBindByPosition(position = 0)
	private int year;
	
	@CsvBindByPosition(position = 1)
	private String title;
	
	@CsvBindByPosition(position = 2)
	private String studios;
	
	@CsvBindByPosition(position = 3)
	private String producers;
	
	@CsvBindByPosition(position = 4)
	private boolean winner;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudios() {
		return studios;
	}

	public void setStudios(String studios) {
		this.studios = studios;
	}

	public String getProducers() {
		return producers;
	}

	public void setProducers(String producers) {
		this.producers = producers;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
}