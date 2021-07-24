package com.razzies.dto;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
	
}