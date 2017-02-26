package com.i3.ecom.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.i3.ecom.model.Users;
import com.i3.ecom.utils.ResponseMessage;

public interface UserService extends UserDetailsService{

	ResponseMessage addUser(final Users userJson);
	
	ResponseMessage editUser(final Users userJson);
	
	ResponseMessage deleteUser(final String userJson);
	
	ResponseMessage getAllUsers();
	
	ResponseMessage getUser(final String emailId);

}
