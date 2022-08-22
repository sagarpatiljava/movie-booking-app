package com.sagar.booking.dao;

import java.util.List;

import com.sagar.booking.entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TheaterDAO extends JpaRepository<TheaterEntity, Integer> {
	
	List<TheaterEntity> findByTheaterName(String theaterName);
	TheaterEntity findByTheaterNameAndCity(String theaterName, String city);

}
