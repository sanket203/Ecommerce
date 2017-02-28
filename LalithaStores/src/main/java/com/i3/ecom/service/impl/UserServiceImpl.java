package com.i3.ecom.service.impl;

import static com.i3.ecom.utils.URLConstants.FAIL_STATUS;
import static com.i3.ecom.utils.URLConstants.SUCCESS_STATUS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.i3.ecom.dao.UserDao;
import com.i3.ecom.model.LoggedInUser;
import com.i3.ecom.model.Roles;
import com.i3.ecom.model.Users;
import com.i3.ecom.service.UserService;
import com.i3.ecom.utils.ResponseMessage;
import com.i3.ecom.utils.UserValidation;

@Service(value= UserServiceImpl.SERVICE_NAME)
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class UserServiceImpl implements UserService {
	public static final String SERVICE_NAME = "UserServiceImpl";
	
@Autowired
UserDao userDao;
@Transactional
	@Override
	public ResponseMessage addUser(final Users userJson) {
		// TODO Auto-generated method stub
		String message = null;
		ResponseMessage responseMessage = null;
		try {
		//Users user = Users.getUser(userJson);
			UserValidation.validateuser(userJson);
			userJson.setCreationDate(new Date());
			userJson.setModificationDate(new Date());
			userJson.setPassword("123456");
			userJson.setStatus(true);
			message = userDao.addUser(userJson);
			Users user = userDao.getUser(userJson.getEmailId());
			userDao.setUserRoles(getUserRoleString(userJson.getRoles()), user.getUserId());
			responseMessage = new ResponseMessage(SUCCESS_STATUS, message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseMessage = new ResponseMessage(FAIL_STATUS, e.getMessage());
		}
		return responseMessage;
	}

private String getUserRoleString(List<String> roles){
	StringBuffer roleString = new StringBuffer();
	
	if(roles.size()==1){
		roleString.append(roles.get(0));
	}
	else{
	for (String role : roles) {
		roleString.append(role+",");
	}
	}
	
	roleString.deleteCharAt(roleString.lastIndexOf(","));
	
	return roleString.toString();
}

@Transactional
	@Override
	public ResponseMessage editUser(Users userJson) {
		// TODO Auto-generated method stub
		String message = null;
		ResponseMessage responseMessage = null;
		Users user = new Users();
		try {
			UserValidation.validateuser(userJson);
			user = userDao.getUser(userJson.emailId);
			userJson.setUserId(user.getUserId());
			userJson.setPassword(user.getPassword());
			userJson.setModificationDate(new Date());
			userJson.setStatus(user.getStatus());
			message = userDao.editUser(userJson);
			Roles roles = userDao.getUserRoles(user.getUserId());
			roles.setRole(getUserRoleString(userJson.getRoles()));
			userDao.updateUserRoles(roles);
			responseMessage = new ResponseMessage(SUCCESS_STATUS, message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseMessage = new ResponseMessage(FAIL_STATUS, e.getMessage());
		}
		return responseMessage;
	}
@Transactional
	@Override
	public ResponseMessage deleteUser(String userJson) {
		String message = null;
		ResponseMessage responseMessage = null;
		try {
		
			message = userDao.deleteUser(userJson);
			responseMessage = new ResponseMessage(SUCCESS_STATUS, message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseMessage = new ResponseMessage(FAIL_STATUS, e.getMessage());
		}
		return responseMessage;
	}
@Transactional
	@Override
	public ResponseMessage getAllUsers() {
		
		List<Users> users = new ArrayList<Users>();
		ResponseMessage response = null;
		try {
			users = userDao.getAllUsers();
			response = new ResponseMessage(SUCCESS_STATUS,null);
			response.setData(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response = new ResponseMessage(FAIL_STATUS, e.getMessage());
		}
		return response;
	}
@Transactional
	@Override
	public ResponseMessage getUser(String userJson) {
		Users user = null;
		ResponseMessage response = null;
		try {
			user = userDao.getUser(userJson);
			response = new ResponseMessage(SUCCESS_STATUS,null);
			response.setData(user);
		} catch (Exception e) {
			response = new ResponseMessage(FAIL_STATUS, e.getMessage());
		}
		
		return response;
	}

@Override
public UserDetails loadUserByUsername(String email)
		throws UsernameNotFoundException {
	LoggedInUser loggedInUser = null;
try {
	Users user = userDao.getUser(email);
	
	if(user == null){
		throw new UsernameNotFoundException("Invalid Username");
	}
	
	 
	
	Roles roles = userDao.getUserRoles(user.getUserId());
	 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	 
	 if(roles!=null){
		 String[] permissionList = roles.getRole().split(",");
		 for (String permissionName : permissionList) {
             authorities.add(new SimpleGrantedAuthority(permissionName));
         }
		 
		 loggedInUser = new LoggedInUser(user.getEmailId(), user.getPassword(), authorities);
		 loggedInUser.setFirstName(user.getFirstName());
		 loggedInUser.setLastName(user.getLastName());
		 loggedInUser.setCurrentUserId(user.getUserId());

	 }
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	return loggedInUser;
}

}
