package com.sagar.user.service;

import java.util.List;

import com.sagar.user.entity.UserEntity;
import com.sagar.user.model.LoginDTO;
import com.sagar.user.model.RequestSignUp;
import com.sagar.user.model.UserDTO;

public interface UserService {

	List<UserDTO> getUserDetails(String userName);
	RequestSignUp registerUser(RequestSignUp requestSignup);
	String delete(String userName);
	UserEntity validateUser(LoginDTO user) throws Exception;
	UserDTO updateUser(UserDTO user);
}