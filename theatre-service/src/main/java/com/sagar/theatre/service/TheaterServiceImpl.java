package com.sagar.theatre.service;

import java.util.ArrayList;
import java.util.List;

import com.sagar.theatre.dao.TheaterDAO;
import com.sagar.theatre.entity.TheaterEntity;
import com.sagar.theatre.model.AddNewTheater;
import com.sagar.theatre.model.TheaterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TheaterServiceImpl implements TheaterService{
	@Autowired
	TheaterDAO theaterDAO;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<TheaterDTO> getTheaterDetails(String theaterName) {
		// TODO Auto-generated method stub
		logger.info("Theater details request for customer {}", theaterName);
		TheaterEntity theaterEntity=theaterDAO.findByTheaterName(theaterName);
		List<TheaterDTO> theaterDTO = new ArrayList<TheaterDTO>();
		theaterDTO.add(TheaterDTO.valueOf(theaterEntity));
		return theaterDTO;
	}
	
	public List<TheaterEntity> getAllTheaters() {
        return theaterDAO.findAll();
    }
	public AddNewTheater addTheater(AddNewTheater addNewTheater) {
		String message = null;
		TheaterEntity theater1 = new TheaterEntity();
			message = addNewTheater.getTheaterName() + "has been added successfully";
			theater1.setTheaterName(addNewTheater.getTheaterName());
			theater1.setAddress(addNewTheater.getAddress());
			theater1.setSeatingCapacity(addNewTheater.getSeatingCapacity());
			theater1.setCity(addNewTheater.getCity());
			theaterDAO.save(theater1);
		return addNewTheater;
	}
	
	public AddNewTheater updateTheater(AddNewTheater theater) {
		TheaterEntity theater1 = new TheaterEntity();
		theater1 = theaterDAO.findByTheaterName(theater.getTheaterName());
		theater1.setTheaterName(theater.getTheaterName());
		theater1.setAddress(theater.getAddress());
		theater1.setSeatingCapacity(theater.getSeatingCapacity());
		theater1.setCity(theater.getCity());
		theaterDAO.save(theater1);
		return theater;
	}
	

	@Override
	public String delete(String theaterName) {
		String message = null;
		TheaterEntity theater1 = new TheaterEntity();
		theater1 = theaterDAO.findByTheaterName(theaterName);
		if ( theater1.getTheaterName().equals(theaterName)){
			message = theater1.getTheaterName() + " has been deleted successfully";
			theaterDAO.delete(theater1);
		}
		return message;
	}
}
