package com.sagar.movie.api;

import java.util.List;

import com.sagar.movie.entity.MovieEntity;
import com.sagar.movie.model.AddNewMovie;
import com.sagar.movie.model.MovieDTO;
import com.sagar.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
public class MovieAPI {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MovieService movieService;
	
	//fetches all movies
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<MovieEntity> allMovies(MovieDTO model) {
        return movieService.getAllMovies();  
    }
	
	// Fetches details of a specific movie
	@RequestMapping(value = "/movies/{movieName}/moviedetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovieDTO> getMovieDetails(@PathVariable String movieName) {

		logger.info("Moviedetails request for user {}", movieName);

		return movieService.getMovieDetails(movieName);
	}
	
	// adds new movie
		@PostMapping(value = "/movies")
		public AddNewMovie addMovie(@RequestBody AddNewMovie addNewMovie) {
			return movieService.addMovie(addNewMovie);
			
		} 
		
	// updates a movie
				@PutMapping(value = "/movies/update",produces = MediaType.APPLICATION_JSON_VALUE)
				public AddNewMovie updateMovie(@RequestBody AddNewMovie addNewMovie) {
					return movieService.updateMovie(addNewMovie);
				} 
		
	// deletes movie
		@RequestMapping(value = "movies/{movieName}", method = RequestMethod.DELETE )
		public String delete(@PathVariable String movieName) {
			String message;
			movieService.delete(movieName);
			message = movieName+" has been deleted successfully";
			return message;
		} 

}
