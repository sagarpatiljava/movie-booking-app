package com.sagar.booking.api;

import java.util.List;

import com.sagar.booking.entity.BookingEntity;
import com.sagar.booking.entity.ShowsEntity;
import com.sagar.booking.model.AddShowDTO;
import com.sagar.booking.model.BookingDTO;
import com.sagar.booking.model.ShowsDTO;
import com.sagar.booking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class BookingAPI {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BookingService bookingService;

	/*@PatchMapping(value = "/booking")
	public BookTicketDTO getBookingDetails(@RequestBody BookTicketDTO bookTicket) {
		return bookingService.getBookingDetails(bookTicket);	
	}*/
	@PostMapping(value = "/bookings")
	public BookingEntity getBookingDetails(@RequestBody BookingDTO bookDTO) {
		return bookingService.book(bookDTO);	
	}
	//fetches all bookings of a user
	@RequestMapping(value = "/bookings/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookingEntity> allbookings(@PathVariable String userName, BookingDTO model) {
		    return bookingService.getAllBookings(userName, model);  
		    }
	
	//fetches all bookings of a show for report
	@RequestMapping(value = "/booking/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookingEntity> moviebook(BookingDTO model) {
		    return bookingService.moviebooking(model);  
		    }
	
	// Fetches details of a specific show
	@RequestMapping(value = "/shows/{showId}/showdetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ShowsDTO> getMovieDetails(@PathVariable Integer showId) {

		logger.info("Showdetails request for user {}", showId);

		return bookingService.getShowDetails(showId);
	} 
	

	//fetches all shows of a movie
		@RequestMapping(value = "/shows/{movieName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<ShowsEntity> allShows(@PathVariable String movieName, AddShowDTO model) {
	        return bookingService.getAllShows(movieName, model);  
	    }
		//fetches all shows
				@RequestMapping(value = "/shows", method = RequestMethod.GET)
			    public List<ShowsEntity> allTheaters(ShowsDTO model) {
			        return bookingService.getAllShows();  
			    }
				
	// adds new show
	@PostMapping(value = "/shows")
	public ShowsEntity addShow(@RequestBody AddShowDTO show) {
		return bookingService.addShow(show);
	}

	// updates show
	@PutMapping(value = "/shows/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ShowsEntity updateShow(@RequestBody AddShowDTO shows) {
		return bookingService.updateShow(shows);
	}

	 // deletes show
	@RequestMapping(value = "/shows/{showId}", method = RequestMethod.DELETE)
	public String deleteShow(@PathVariable Integer showId) {
		String message;
		message = bookingService.deleteShow(showId);
		return message;
	}

	// cancels Booking
	@RequestMapping(value = "/bookings/{bookingId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer bookingId) {
		String message;
		message = bookingService.delete(bookingId);
		return message;
	}

}
