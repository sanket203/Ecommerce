package com.i3.ecom.dao;

import java.util.List;

import com.i3.ecom.model.Customer;
import com.i3.ecom.model.Order;

public interface OrderDao {
	
	public List<Order> getOrdersByDate();
	
	public List<Order> getOrderByStatus(final String status);
	
	public Order getOrderByOrderDetailId(final String orderDetailId);
	
	public void updateOrder(final Order order);
	
	public Customer getCustomerById(long customerId);

}
