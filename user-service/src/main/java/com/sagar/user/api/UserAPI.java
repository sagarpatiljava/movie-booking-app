package com.sagar.user.api;

import java.util.List;

import com.sagar.user.entity.UserEntity;
import com.sagar.user.model.LoginDTO;
import com.sagar.user.model.RequestSignUp;
import com.sagar.user.model.UserDTO;
import com.sagar.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
public class UserAPI {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;

	// Fetches details of a specific user
	@RequestMapping(value = "/users/{userName}/userdetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> getUserDetails(@PathVariable String userName) {
		try {
		logger.info("Userdetails request for user {}", userName);
		return userService.getUserDetails(userName);
		}
		catch (Exception ex) {
			throw ex;
		}
	}

	// adds new user
	@PostMapping(value = "/users/signup", consumes = "application/json" )
	public RequestSignUp registerUser(@RequestBody RequestSignUp requestSignup) {
		try {
			return userService.registerUser(requestSignup);
			
		} catch (Exception ex) {
			throw ex;
		}

	}
	
	// updates user details
	@PutMapping(value = "/users/update",produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO updateUser( @RequestBody UserDTO user) {
		return userService.updateUser(user);
	} 

	// validates user with password
	@PostMapping(value = "/login", consumes = "application/json" )
    public UserEntity validateUser(@RequestBody LoginDTO user) throws Exception{
		return userService.validateUser(user);
                    
    	} 
	
	// deletes user
			@RequestMapping(value = "users/{userName}", method = RequestMethod.DELETE )
			public String delete(@PathVariable String userName) {
				String message;
				message = userService.delete(userName);
				return message;
			} 
}