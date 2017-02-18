package com.i3.ecom.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.i3.ecom.dao.UserDao;
import com.i3.ecom.model.Users;
import com.i3.ecom.service.UserService;
import com.i3.ecom.utils.ResponseMessage;

import static com.i3.ecom.utils.URLConstants.SUCCESS_STATUS;
import static com.i3.ecom.utils.URLConstants.FAIL_STATUS;

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
			userJson.setCreationDate(new Date());
			userJson.setModificationDate(new Date());
			userJson.setPassword("123456");
			userJson.setStatus(true);
			message = userDao.addUser(userJson);
			responseMessage = new ResponseMessage(SUCCESS_STATUS, message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseMessage = new ResponseMessage(FAIL_STATUS, e.getCause().getMessage());
		}
		return responseMessage;
	}

@Transactional
	@Override
	public ResponseMessage editUser(Users userJson) {
		// TODO Auto-generated method stub
		String message = null;
		ResponseMessage responseMessage = null;
		Users user = new Users();
		try {
			user = userDao.getUser(userJson.emailId);
			userJson.setUserId(user.getUserId());
			userJson.setPassword(user.getPassword());
			userJson.setModificationDate(new Date());
			userJson.setStatus(user.getStatus());
			message = userDao.editUser(userJson);
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

}
