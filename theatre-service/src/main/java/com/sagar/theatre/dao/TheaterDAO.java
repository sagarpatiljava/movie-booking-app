package com.sagar.theatre.dao;

import java.util.List;

import com.sagar.theatre.entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TheaterDAO extends JpaRepository<TheaterEntity, Integer> {

	TheaterEntity findByTheaterNameAndCity(String theaterName, String city);
	TheaterEntity findByTheaterName(String theaterName);

}
