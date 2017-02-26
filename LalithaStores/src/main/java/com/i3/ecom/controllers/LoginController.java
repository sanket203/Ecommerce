package com.i3.ecom.controllers;

import static com.i3.ecom.utils.URLConstants.ADMIN_LOGIN;
import static com.i3.ecom.utils.URLConstants.LOGIN;
import static com.i3.ecom.utils.URLConstants.LOGIN_FAILED;
import static com.i3.ecom.utils.URLConstants.LOGOUT;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.i3.ecom.model.LoggedInUser;
import com.i3.ecom.utils.UserConstants;

@Controller
public class LoginController {
	
	 @RequestMapping(value=ADMIN_LOGIN, method = RequestMethod.GET)
	 public String executeSecurity(ModelMap model, HttpServletRequest request) {
		 LoggedInUser loggedInUser = null;
	        HttpSession session = null;
	  try{
		  
		  session = request.getSession();
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
          String currentUserName = authentication.getName();
          
          session.setAttribute(UserConstants.LOGGEDIN_USERNAME, currentUserName);
          
          Object principal = authentication.getPrincipal();
          if (principal instanceof UserDetails) {
              loggedInUser = (LoggedInUser) principal;
          }
          
          if(loggedInUser != null){
        	  session.setAttribute(UserConstants.LOGGED_IN_USER, loggedInUser);
          }
		  
	  }
	  
	  catch(Exception e){
		  
	  }
	  return "admin";
	 
	 }
	 
	
	 @RequestMapping(value=LOGIN, method = RequestMethod.GET)
	 public String login(ModelMap model) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  
		 if (!(auth instanceof AnonymousAuthenticationToken)) {
             return "admin";
         }
	  return "login";
	 
	 }
	
	@RequestMapping(value=LOGIN_FAILED, method = RequestMethod.GET)
	 public String loginerror(ModelMap model) {
	 
	  model.addAttribute("error", "true");
	  return "login";
	 
	 }
	
	@RequestMapping(value=LOGOUT, method = RequestMethod.GET)
	 public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		 session.invalidate();
	 
	  return "login";
	 
	 }

}
