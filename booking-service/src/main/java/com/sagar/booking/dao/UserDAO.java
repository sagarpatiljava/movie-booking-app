package com.sagar.booking.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.sagar.booking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface UserDAO extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUserName(String userName);



}
