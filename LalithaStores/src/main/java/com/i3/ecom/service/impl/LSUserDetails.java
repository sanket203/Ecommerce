package com.i3.ecom.service.impl;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.i3.ecom.service.LSUSerDetailsService;

public class LSUserDetails implements LSUSerDetailsService{

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getUserDetails(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

}
