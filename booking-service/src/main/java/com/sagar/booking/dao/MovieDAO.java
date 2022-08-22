package com.sagar.booking.dao;

import java.util.List;

import com.sagar.booking.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface MovieDAO extends JpaRepository<MovieEntity, Integer> {
	MovieEntity findByMovieName(String movieName);
}
