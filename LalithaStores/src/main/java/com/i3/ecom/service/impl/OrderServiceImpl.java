package com.i3.ecom.service.impl;

import static com.i3.ecom.utils.URLConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i3.ecom.dao.OrderDao;
import com.i3.ecom.dao.OrderDetailsDao;
import com.i3.ecom.dao.ProductsDao;
import com.i3.ecom.model.Customer;
import com.i3.ecom.model.Order;
import com.i3.ecom.pojo.OrdersPojo;
import com.i3.ecom.service.OrderService;
import com.i3.ecom.utils.ResponseMessage;

@Service(value=OrderServiceImpl.SERVICE_NAME)
public class OrderServiceImpl implements OrderService {

	public static final String SERVICE_NAME = "OrderServiceImpl";
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	@Autowired
	private ProductsDao prodductDao;

	@Override
	@Transactional
	public ResponseMessage getLatestOrders() {
		ResponseMessage response = null;
		String message = null;
		List<OrdersPojo> orders = new ArrayList<OrdersPojo>();
		try {
			 List<Order> orderList = orderDao.getOrdersByDate();
			 if(orderList.size()>0){
				 ordersToView(orderList, orders);
				 response = new ResponseMessage(SUCCESS_STATUS, orders, message);
			 } else {
				 message = "No orders yet.";
				 response = new ResponseMessage(FAIL_STATUS, message);
			 }
		} catch(Exception ex) {
			message = ex.getCause().getMessage();
			response = new ResponseMessage(FAIL_STATUS, message);
		}
		return response;
	}

	private void ordersToView(List<Order>orderList, List<OrdersPojo> orders) {
		for (Order order : orderList) {
			OrdersPojo orderPojo = new OrdersPojo();
			orderPojo.setExpectedDelivery(order.getExpectedDelivery());
			orderPojo.setOrderDate(order.getOrderDate());
			orderPojo.setTotalAmount(order.getTotalAmount());
			orderPojo.setStatus(order.getStatus());
			orderPojo.setOrderDetailsId(order.getOrderDetailsId());
			orderPojo.setOrderId(order.getOrderId());
			Customer customerById = orderDao.getCustomerById(order.getCustomerId());
			orderPojo.setCustomer(customerById.getFirstName() + " " + customerById.getLastName());
			orders.add(orderPojo);
		}
	}

	@Override
	public ResponseMessage getOrderByDetailId(final String orderDetailId) {
		ResponseMessage response = null;
		String message = null;
		OrdersPojo order = new OrdersPojo();
		try {
			 Order orderById = orderDao.getOrderByOrderDetailId(orderDetailId);
			 if(orderById != null){
				 
				 ordersToOrderPojo(orderById, order);
				 response = new ResponseMessage(SUCCESS_STATUS, order, message);
			 } else {
				 message = "No orders yet.";
				 response = new ResponseMessage(FAIL_STATUS, message);
			 }
		} catch(Exception ex) {
			message = ex.getCause().getMessage();
			response = new ResponseMessage(FAIL_STATUS, message);
		}
		return response;
	}

	private void ordersToOrderPojo(Order orderById, OrdersPojo order) {
		order.setExpectedDelivery(orderById.getExpectedDelivery());
		order.setOrderDate(orderById.getOrderDate());
		order.setTotalAmount(orderById.getTotalAmount());
		order.setStatus(orderById.getStatus());
		order.setOrderDetailsId(orderById.getOrderDetailsId());
		order.setOrderId(orderById.getOrderId());
		Customer customerById = orderDao.getCustomerById(orderById.getCustomerId());
		order.setCustomer(customerById.getFirstName() + " " + customerById.getLastName());
		
	}

	@Override
	public ResponseMessage getOrderByStatus(final String status) {
		ResponseMessage response = null;
		String message = null;
		List<OrdersPojo> orders = new ArrayList<OrdersPojo>();
		try {
			 List<Order> orderList = orderDao.getOrderByStatus(status);
			 if(orderList.size()>0){
				 ordersToView(orderList, orders);
				 response = new ResponseMessage(SUCCESS_STATUS, orders, message);
			 } else {
				 message = "No orders yet.";
				 response = new ResponseMessage(FAIL_STATUS, message);
			 }
		} catch(Exception ex) {
			message = ex.getCause().getMessage();
			response = new ResponseMessage(FAIL_STATUS, message);
		}
		return response;
	}
	
	
}
