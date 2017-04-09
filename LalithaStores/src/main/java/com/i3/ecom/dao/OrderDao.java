package com.i3.ecom.dao;

import java.util.List;

import com.i3.ecom.model.Customer;
import com.i3.ecom.model.Order;
import com.i3.ecom.model.Product;
import com.i3.ecom.pojo.AddressPojo;

public interface OrderDao {
	
	public List<Order> getOrdersByDate();
	
	public List<Order> getOrderByStatus(final String status);
	
	public Order getOrderByOrderDetailId(final String orderDetailsId);
	
	public String updateOrder(final String orderDetailsId, final String status);
	
	public Customer getCustomerById(long customerId);
	
	public List<Product> getOrderedProducts(List<Long> productsIds);
	
	public AddressPojo getOrderAddress(final long addressId);

	public List<Order> getOrders();


}
