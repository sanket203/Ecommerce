package com.i3.ecom.pojo;

import java.util.Date;
import java.util.List;

public class OrdersPojo {

    private long orderId;
	private String orderDetailsId;
	private String customer;
	private String totalAmount;
	private String paymentMode;
	private Address address;
	private String status;
	private Date orderDate;
	private Date expectedDelivery;
	private Date modificationDate;
	private List<ProductPojo> products;
	
	public List<ProductPojo> getProducts() {
		return products;
	}
	public void setProducts(List<ProductPojo> products) {
		this.products = products;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(String orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getExpectedDelivery() {
		return expectedDelivery;
	}
	public void setExpectedDelivery(Date expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
}
