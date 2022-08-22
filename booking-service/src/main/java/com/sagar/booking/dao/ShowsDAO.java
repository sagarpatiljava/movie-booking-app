package com.sagar.booking.dao;


import com.sagar.booking.entity.ShowsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ShowsDAO extends JpaRepository<ShowsEntity, Integer> {

	ShowsEntity findByMovieNameAndTheaterName(String movieName, String theaterName);
	ShowsEntity findByShowId(Integer showId);
	List<ShowsEntity> findAllByMovieName(String movieName);
	
}

