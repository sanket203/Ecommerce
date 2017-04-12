package com.i3.ecom.service.impl;

import static com.i3.ecom.utils.URLConstants.FAIL_STATUS;
import static com.i3.ecom.utils.URLConstants.SUCCESS_STATUS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i3.ecom.dao.OrderDao;
import com.i3.ecom.dao.OrderDetailsDao;
import com.i3.ecom.dao.ProductsDao;
import com.i3.ecom.model.Customer;
import com.i3.ecom.model.Order;
import com.i3.ecom.model.OrderDetails;
import com.i3.ecom.model.Product;
import com.i3.ecom.pojo.OrdersPojo;
import com.i3.ecom.pojo.ProductPojo;
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

	/**
	 * This method will return the list of all latest orders by customers.
	 * @param orderList
	 * @param orders
	 */
	private void ordersToView(List<Order>orderList, List<OrdersPojo> orders) {
		for (Object object : orderList) {
			Order order = (Order)object;
			OrdersPojo orderPojo = new OrdersPojo();
			orderPojo.setExpectedDelivery(createDate(order.getExpectedDelivery()));
			orderPojo.setOrderDate(createDate(order.getOrderDate()));
			orderPojo.setTotalAmount(order.getTotalAmount());
			orderPojo.setStatus(order.getStatus());
			orderPojo.setPaymentMode(order.getPaymentMode());
			orderPojo.setOrderDetailsId(order.getOrderDetailsId());
			orderPojo.setOrderId(order.getOrderId());
			Customer customerById = orderDao.getCustomerById(order.getCustomerId());
			orderPojo.setCustomer(customerById.getFirstName() + " " + customerById.getLastName());
			orderPojo.setContact(customerById.getContact());
			orderPojo.setEmailId(customerById.getEmailId());
			orders.add(orderPojo);
			
		}
	}
	
	private String createDate(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String format = formatter.format(date.getTime());
		return format;
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
				 List<OrderDetails> productsOrdered = orderDetailsDao.getOrderDetailsById(orderById.getOrderDetailsId());
				 List<ProductPojo> products = getProductsInOrder(productsOrdered);
				 order.setProducts(products);
				 order.setAddress(orderDao.getOrderAddress(orderById.getAddressId()));
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

	/**
	 * This method create single order based on order detail id.
	 * @param productsOrdered
	 * @return
	 */
	private List<ProductPojo> getProductsInOrder(List<OrderDetails> productsOrdered) {
		List<Long>prodIds = new LinkedList<Long>();
		for (OrderDetails orderDetails : productsOrdered) {
			prodIds.add(orderDetails.getProductId());
		}
		List<Product> orderedProducts = orderDao.getOrderedProducts(prodIds);
		List<ProductPojo> productsInOrder = new LinkedList<ProductPojo>();
		for(int i=0;i<orderedProducts.size();i++){
			ProductPojo product = new ProductPojo();
			product.setAmount(productsOrdered.get(i).getProductAmount());
			product.setQuantity(productsOrdered.get(i).getProductQuantity());
			int location = 0;
			for(int j=0;j<orderedProducts.size();j++){
				if(productsOrdered.get(i).getProductId() == orderedProducts.get(j).getProductId()){
					location = j;
				}
			}
			product.setProductName(orderedProducts.get(location).getProductName());
			productsInOrder.add(product);
		}
		return productsInOrder;
	}

	private void ordersToOrderPojo(Order orderById, OrdersPojo order) {
		order.setExpectedDelivery(createDate(orderById.getExpectedDelivery()));
		order.setOrderDate(createDate(orderById.getOrderDate()));
		order.setTotalAmount(orderById.getTotalAmount());
		order.setStatus(orderById.getStatus());
		order.setOrderDetailsId(orderById.getOrderDetailsId());
		order.setOrderId(orderById.getOrderId());
		Customer customerById = orderDao.getCustomerById(orderById.getCustomerId());
		order.setCustomer(customerById.getFirstName() + " " + customerById.getLastName());
		order.setContact(customerById.getContact());
		order.setEmailId(customerById.getEmailId());
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

	@Override
	public ResponseMessage getAllOrders() {
		ResponseMessage response = null;
		String message = null;
		List<OrdersPojo> orders = new ArrayList<OrdersPojo>();
		try {
			 List<Order> orderList = orderDao.getOrders();
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

	@Override
	public ResponseMessage updateOrderStatus(final String orderDetailsId, final String status) {
		ResponseMessage response = null;
		String message = null;
		try {
			 message = orderDao.updateOrder(orderDetailsId,status);
			 response = new ResponseMessage(SUCCESS_STATUS, message);
		} catch(Exception ex) {
			message = ex.getCause().getMessage();
			response = new ResponseMessage(FAIL_STATUS, message);
		}
		return response;
	}
	
}
