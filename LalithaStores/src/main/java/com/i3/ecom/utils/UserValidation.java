package com.i3.ecom.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.i3.ecom.model.Users;

public class UserValidation {
	
	public static void validateuser(Users user) throws Exception{
		
		try {
			validateData(user.emailId);
			validateData(user.firstName);
			validateRoles(user.roles);
			validateData(user.lastName);
			
		} catch (Exception e) {
			throw new Exception("One of the mandatoryfield is empty. Please fill all information");

		}
		
	}
	
	private static void validateRoles(List<String> roles) throws Exception {
		if(CollectionUtils.isEmpty(roles)){
			throw new Exception("One of the mandatoryfield is empty. Please fill all information");
		}
		
	}

	private static void validateData(String data) throws Exception{
		if(StringUtils.isEmpty(data)){
			throw new Exception("One of the mandatoryfield is empty. Please fill all information");
		}
	}

}
