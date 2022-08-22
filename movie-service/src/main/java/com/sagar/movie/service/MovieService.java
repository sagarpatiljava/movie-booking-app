package com.sagar.movie.service;

import java.util.List;


import com.sagar.movie.entity.MovieEntity;
import com.sagar.movie.model.AddNewMovie;
import com.sagar.movie.model.MovieDTO;

public interface MovieService {
	 List<MovieDTO> getMovieDetails (String movieName);
	 AddNewMovie addMovie(AddNewMovie addNewMovie);
	 String delete(String movieName);
	 AddNewMovie updateMovie( AddNewMovie addNewMovie);
	 List<MovieEntity> getAllMovies();
}
