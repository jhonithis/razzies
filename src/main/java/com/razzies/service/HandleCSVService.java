package com.razzies.service;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.razzies.dto.MovieCsv;
import com.razzies.model.Movie;
import com.razzies.model.Producer;
import com.razzies.model.Studio;

@Service
public class HandleCSVService {
	
	private static final String MOVIE_FILE_PATH = "csv/movielist.csv";
	private static final String SEPARATOR_COMMA = ", ";
	private static final String SEPARATOR_AND = " and ";
	private static final Logger log = LoggerFactory.getLogger(HandleCSVService.class);
	
	@Autowired
	private MovieService movieService;

	public void init() {
		try {
			
			List<MovieCsv> moviesCsv = this.readCSVParseToDTO();
			if(moviesCsv.isEmpty()) {
				log.error("Não foi encontrado dados no arquivo csv");
				return;
			}
			
			movieService.saveMovies(this.buildMovieByListMovieCsv(moviesCsv));
		
		} catch (Exception e) {
			log.error("Erro no processo de inserção do csv");
			e.printStackTrace();
		}
		
		log.info("Exportação do csv realizada com sucesso");
		
	}
	
	private List<MovieCsv> readCSVParseToDTO() throws IOException, URISyntaxException {
		
		List<MovieCsv> moviesCsv = new ArrayList<MovieCsv>();
			
		Reader reader = Files.newBufferedReader(this.getPathCsv());
		moviesCsv = new CsvToBeanBuilder(reader)
			.withType(MovieCsv.class)
			.withSkipLines(1)
			.withSeparator(';')
			.build()
			.parse();
		
		return moviesCsv;
		
	}
	
	private List<Movie> buildMovieByListMovieCsv(List<MovieCsv> moviesCsv) throws Exception {
		
		List<Movie> movies = new ArrayList<Movie>(); 
		
		moviesCsv.forEach(movieCsv -> {
			Movie movie = new Movie(movieCsv.getTitle(), movieCsv.getYear(), movieCsv.isWinner());
			movie.setProducers(buildProducers(movie, movieCsv.getProducers()));
			movie.setStudios(buildStudios(movie, movieCsv.getStudios()));
			movies.add(movie);
		});
		
		return movies;
	}
	
	private List<Producer> buildProducers (Movie movie, String producersMovieCsv) {
		List<Producer> producers = new ArrayList<Producer>();
		Arrays.asList(
			producersMovieCsv.replaceAll(SEPARATOR_AND, SEPARATOR_COMMA).split(SEPARATOR_COMMA)
		).stream().forEach(produceCsv -> {
			producers.add(
				new Producer(produceCsv, movie)
			);
		});
		return producers;
	}
	
	private List<Studio> buildStudios (Movie movie, String studiosMovieCsv) {
		List<Studio> studios = new ArrayList<Studio>();
		Arrays.asList(
			studiosMovieCsv.split(SEPARATOR_COMMA)
		).stream().forEach(produceCsv -> {
			studios.add(
				new Studio(produceCsv, movie)
			);
		});
		return studios;
	}
	
	private Path getPathCsv() throws URISyntaxException {
		Path path = Paths.get(ClassLoader.getSystemResource(MOVIE_FILE_PATH).toURI());
		return path;
	}

}