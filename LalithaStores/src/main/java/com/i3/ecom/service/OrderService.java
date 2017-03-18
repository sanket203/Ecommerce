package com.i3.ecom.service;

import com.i3.ecom.utils.ResponseMessage;

public interface OrderService {

	public ResponseMessage getLatestOrders();
	
	public ResponseMessage getOrderByDetailId(final String orderDetailId);
	
	public ResponseMessage getOrderByStatus(final String status);
}