package com.i3.ecom.controllers;

import static com.i3.ecom.utils.URLConstants.GET_LATEST_ORDER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i3.ecom.service.OrderService;
import com.i3.ecom.utils.ResponseMessage;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value=GET_LATEST_ORDER, method=RequestMethod.GET)
	public ResponseMessage latestOrders(){
		ResponseMessage message = orderService.getLatestOrders();
		return message;
	}
	
	public ResponseMessage getOrderByStatus(@RequestParam("orderStatus") final String status){
		ResponseMessage message = orderService.getOrderByStatus(status);
		return message;
	}
	
}
