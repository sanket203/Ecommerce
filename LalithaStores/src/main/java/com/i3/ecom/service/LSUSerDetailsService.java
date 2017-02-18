package com.i3.ecom.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface LSUSerDetailsService extends UserDetailsService {
	
	List<Object> getUserDetails(final String emailId);

}
