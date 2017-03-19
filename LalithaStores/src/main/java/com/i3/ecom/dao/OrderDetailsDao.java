package com.i3.ecom.dao;

import java.util.List;

import com.i3.ecom.model.OrderDetails;

public interface OrderDetailsDao {

	public List<OrderDetails> getOrderDetailsById(final String orderDetailsId);
	
	public void updateOrderDetails(final OrderDetails orderDetails);
}
