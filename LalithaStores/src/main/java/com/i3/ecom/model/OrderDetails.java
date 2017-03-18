package com.i3.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="orderdetails")
public class OrderDetails {

	@Id
	@GeneratedValue
	@Column(name="orderId")
	private long orderId;
	
	@Column(name="orderDetailsId")
	private String orderDetailsId;
	
	@Column(name="productId")
	private long productId;
	
	@Column(name="productQuantity")
	private int productQuantity;
	
	@Column(name="productAmount")
	private String productAmount;

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

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}
	
	
	
}
