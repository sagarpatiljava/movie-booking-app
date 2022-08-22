package com.sagar.booking.dao;

import java.util.List;


import com.sagar.booking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface BookingDAO extends JpaRepository<BookingEntity, Integer> {
	BookingEntity findByBookingId(Integer bookingId);
	List<BookingEntity> findAllByUserName(String userName);
	List<BookingEntity> findAllByShowId(Integer showId);
}
