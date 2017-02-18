package com.i3.ecom.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.i3.ecom.model.Customer;
import com.i3.ecom.utils.ResponseMessage;

import static com.i3.ecom.utils.URLConstants.ADD_CUSTOMER;

@Controller
public class CustomerController {
	
	@RequestMapping(value=ADD_CUSTOMER,method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseMessage addUser(@RequestBody final Customer customerJson){
		
		return null;
	}

}
