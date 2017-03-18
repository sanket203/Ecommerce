package com.i3.ecom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="order")
public class Order {

	@Id
	@GeneratedValue
	@Column(name="orderId")
	private long orderId;
	
	@Column(name="orderDetailsId")
	private String orderDetailsId;
	
	@Column(name="customerId")
	private long customerId;
	
	@Column(name="totalAmount")
	private String totalAmount;
	
	@Column(name="paymentMode")
	private String paymentMode;
	
	@Column(name="addressId")
	private long addressId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="orderDate")
	private Date orderDate;
	
	@Column(name="expectedDelivery")
	private Date expectedDelivery;
	
	@Column(name="modificationDate")
	private Date modificationDate;

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

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
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
