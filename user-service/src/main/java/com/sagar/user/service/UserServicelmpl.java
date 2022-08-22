package com.sagar.user.service;

import java.util.ArrayList;
import java.util.List;

import com.sagar.user.dao.UserDAO;
import com.sagar.user.entity.UserEntity;
import com.sagar.user.model.LoginDTO;
import com.sagar.user.model.RequestSignUp;
import com.sagar.user.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServicelmpl implements UserService {

	@Autowired
	UserDAO userDAO;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	public List<UserDTO> getUserDetails(String userName) {
		logger.info("Calldetails request for customer {}", userName);
		UserEntity userEntity = userDAO.findByUserName(userName);
		List<UserDTO> userDTO = new ArrayList<UserDTO>();
		userDTO.add(UserDTO.valueOf(userEntity));
		return userDTO;
	}
	
	public RequestSignUp registerUser(RequestSignUp user) {
		UserEntity user1 = new UserEntity();
		if (user.getPassword().equals(user.getConformPassword())) {
			user1.setUserName(user.getUserName());
			user1.setPhoneNumber(user.getPhoneNumber());
			user1.setEmailId(user.getEmailId());
			user1.setAge(user.getAge());
			user1.setPassword(user.getPassword());
			user1.setRole("User");
			userDAO.save(user1);
		}
		else {
			user=null;
		}	
		return user;
	}
	
	public String delete(String userName) {
		String message = null;
		UserEntity user1 = new UserEntity();
		user1 = userDAO.findByUserName(userName);
		if ( user1.getUserName().equals(userName)){
			message = user1.getUserName() + " has been deleted successfully";
			userDAO.delete(user1);	
		}
		return message;

	}
	
	@Override
	public UserEntity validateUser(LoginDTO user) throws Exception {
		UserEntity login = null;
        UserEntity user1=userDAO.findByUserName(user.getUserName());
        if(user1.getPassword().equals(user.getPassword())){
        login = user1;
        }
        
        else {
        	login = null;
        }
       return login;
	}
	

	public UserDTO updateUser(UserDTO user) {
		UserEntity user1 = new UserEntity();
		user1 = userDAO.findByUserName(user.getUserName());
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setPhoneNumber(user.getPhoneNumber());
		user1.setEmailId(user.getEmailId());
		user1.setAge(user.getAge());
		user1.setRole("User");
		userDAO.save(user1);
		return user;
	}

}

