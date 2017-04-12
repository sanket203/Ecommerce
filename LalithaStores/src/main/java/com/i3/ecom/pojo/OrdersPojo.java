package com.i3.ecom.pojo;

import java.util.Date;
import java.util.List;

public class OrdersPojo {

    private long orderId;
	private String orderDetailsId;
	private String customer;
	private String contact; 
	private String emailId;
	private String totalAmount;
    private String paymentMode;
	private AddressPojo address;
	private String status;
	private String orderDate;
	private String expectedDelivery;
	private String modificationDate;
	private List<ProductPojo> products;
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
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
	public AddressPojo getAddress() {
		return address;
	}
	public void setAddress(AddressPojo address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getExpectedDelivery() {
		return expectedDelivery;
	}
	public void setExpectedDelivery(String expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}
	public String getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	
}
