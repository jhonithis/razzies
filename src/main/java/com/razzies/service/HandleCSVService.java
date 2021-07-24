package com.razzies.service;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opencsv.bean.CsvToBeanBuilder;
import com.razzies.dto.MovieCsv;
import com.razzies.model.Movie;
import com.razzies.repository.MovieRepository;

import lombok.extern.java.Log;

@Service
@Log
public class HandleCSVService {
	
	private static final String MOVIE_FILE_PATH = "csv/movielist.csv";
	
	@Autowired
	private MovieRepository movieRepository;

	public void init() {
		try {
			
			List<MovieCsv> moviesCsv = this.readCSVParseToDTO();
			if(moviesCsv.isEmpty()) {
				log.severe("Não foi encontrado dados no arquivo csv");
				return;
			}
			
			this.saveMovies(this.buildMovieByListMovieCsv(moviesCsv));
		
		} catch (Exception e) {
			log.severe("Erro no processo de inserção do csv");
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
			movies.add(
				Movie.builder().
					year(movieCsv.getYear()).
					title(movieCsv.getTitle()).
					winner(movieCsv.isWinner()).
				build()
			);
		});
		
		return movies;
	}
	
	private Path getPathCsv() throws URISyntaxException {
		Path path = Paths.get(ClassLoader.getSystemResource(MOVIE_FILE_PATH).toURI());
		return path;
	}
	
	@Transactional
	private void saveMovies(List<Movie> movies) throws Exception {
		movies.forEach(movie -> movieRepository.save(movie));
	}

}
