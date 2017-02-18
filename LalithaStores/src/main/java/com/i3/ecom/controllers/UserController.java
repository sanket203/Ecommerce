package com.i3.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.i3.ecom.utils.URLConstants.ADD_USER;
import static com.i3.ecom.utils.URLConstants.DELETE_USER;
import static com.i3.ecom.utils.URLConstants.GET_ALL_USERS;
import static com.i3.ecom.utils.URLConstants.GET_USER;
import static com.i3.ecom.utils.URLConstants.UPDATE_USER;

import com.google.gson.Gson;
import com.i3.ecom.model.Users;
import com.i3.ecom.service.UserService;
import com.i3.ecom.utils.ResponseMessage;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value=ADD_USER,method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseMessage addUser(@RequestBody final Users userJson){
		
		ResponseMessage message = userService.addUser(userJson);
		return message;
	}
	
	@RequestMapping(value=UPDATE_USER,method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody ResponseMessage editUser(@RequestBody final Users userJson){
		
		ResponseMessage message = userService.editUser(userJson);
		return message;
	}
	
	@RequestMapping(value=DELETE_USER,method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody ResponseMessage deleteUser(@RequestBody final Users userJson){
		
		ResponseMessage message = userService.deleteUser(userJson.emailId);
		return message;
	}
	
	@RequestMapping(value=GET_ALL_USERS,method=RequestMethod.GET)
	public @ResponseBody ResponseMessage getAllUsers(){
		
		ResponseMessage message = userService.getAllUsers();
		return message;
	}
	
	@RequestMapping(value=GET_USER,method=RequestMethod.GET,consumes="application/json")
	public @ResponseBody ResponseMessage getUser(@RequestParam("emailId") final String emailId){
		ResponseMessage message = userService.getUser(emailId);
		return message;
	}

}
