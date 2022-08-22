package com.sagar.booking.service;


import com.sagar.booking.entity.BookingEntity;
import com.sagar.booking.entity.ShowsEntity;
import com.sagar.booking.model.AddShowDTO;
import com.sagar.booking.model.BookingDTO;
import com.sagar.booking.model.ShowsDTO;

import java.util.List;


public interface BookingService {

	//BookTicketDTO getBookingDetails(BookTicketDTO bookTicket);
	List<ShowsDTO> getShowDetails(Integer showId);
	ShowsEntity addShow(AddShowDTO show);
	ShowsEntity updateShow(AddShowDTO shows);
	String deleteShow(Integer showId);
	String delete(Integer bookingId);
	BookingEntity book(BookingDTO bookDTO);
	List<ShowsEntity> getAllShows(String movieName, AddShowDTO model);
	List<BookingEntity> getAllBookings(String userName, BookingDTO model);
	List<ShowsEntity> getAllShows();
	List<BookingEntity> moviebooking( BookingDTO model);
}
