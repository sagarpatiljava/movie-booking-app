package com.sagar.theatre.service;

import java.util.List;

import com.sagar.theatre.entity.TheaterEntity;
import com.sagar.theatre.model.AddNewTheater;
import com.sagar.theatre.model.TheaterDTO;

public interface TheaterService {
	 List<TheaterDTO> getTheaterDetails (String theaterName);
	 AddNewTheater addTheater(AddNewTheater addNewTheater);
	 AddNewTheater updateTheater(AddNewTheater theater);
	 String delete(String theaterName);
	 List<TheaterEntity> getAllTheaters();
} 
