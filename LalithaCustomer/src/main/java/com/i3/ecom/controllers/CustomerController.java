package com.i3.ecom.controllers;


import static com.i3.ecom.utils.URLConstants.ADD_CUSTOMER;
import static com.i3.ecom.utils.URLConstants.LOGIN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.i3.ecom.model.Customer;
import com.i3.ecom.service.CustomerService;
import com.i3.ecom.utils.ResponseMessage;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value=ADD_CUSTOMER,method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseMessage registerCustomer(@RequestBody final Customer customer,HttpServletRequest request, HttpServletResponse response){
		ResponseMessage message = customerService.addCustomer(customer);
		HttpSession session = null;
		if(message.getStatus().equals("200")){
			session = request.getSession();
			session.setAttribute("customer", customer);
		}
		return message;
	}
	
	@RequestMapping(value=LOGIN,method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseMessage authenticateCustomer(@RequestParam("userName") String emailId,
			                                                  @RequestParam("password") String password,
			                                                  HttpServletRequest request, HttpServletResponse response){
		ResponseMessage message = customerService.checkUser(emailId,password);
		HttpSession session = null;
		if(message.getStatus().equals("200")){
			session = request.getSession();
			session.setAttribute("customer", (Customer)message.getData());
		}
		return message;
	}

}
