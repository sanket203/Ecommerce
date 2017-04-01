package com.i3.ecom.dao;

import java.util.List;

import com.i3.ecom.model.Customer;
import com.i3.ecom.model.Order;
import com.i3.ecom.model.Product;
import com.i3.ecom.pojo.Address;

public interface OrderDao {
	
	public List<Order> getOrdersByDate();
	
	public List<Order> getOrderByStatus(final String status);
	
	public Order getOrderByOrderDetailId(final String orderDetailsId);
	
	public void updateOrder(final Order order);
	
	public Customer getCustomerById(long customerId);
	
	public List<Product> getOrderedProducts(List<Long> productsIds);
	
	public Address getOrderAddress(final long addressId);

}
