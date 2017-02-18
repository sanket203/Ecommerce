package com.i3.ecom.model;


import java.util.Date;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.json.JSONObject;


@Entity(name="Product")
public class Product {
 
	@Id
	@GeneratedValue
	@Column(name="productId")
	private long productId;
	
	@Column(name="categoryId")
	private long categoryId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="quantity_in_weight")
	private String quantityWeight;
	
	@Column(name="productActive")
	private boolean productActive;
	
	@Column(name="productLocation")
	private String productLocation;
	
	@Column(name="tags")
	private String tags;
	
	@Column(name="price")
	private String price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="creationDate")
	private Date creationDate;
	
	@Column(name="modificationDate")
	private Date modificationDate;
	
	@Column(name="imageFileName")
	private String imageFileName;
	
	
	
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityWeight() {
		return quantityWeight;
	}

	public void setQuantityWeight(String quantityWeight) {
		this.quantityWeight = quantityWeight;
	}

	public boolean isProductActive() {
		return productActive;
	}

	public void setProductActive(boolean productActive) {
		this.productActive = productActive;
	}

	public String getProductLocation() {
		return productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	public static Product createProductEntity(String productJson) {
		Product product = new Product();
		JSONObject jsonObject = new JSONObject(productJson);
		Iterator<?> keys = jsonObject.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			switch (key) {
			case "id":
				product.setProductId(jsonObject.getLong(key));
				break;
			case "productName":
				product.setProductName(jsonObject.getString(key));
				break;
			case "description":
				product.setDescription(jsonObject.getString(key));
				break;
			case "categoryId":
				product.setCategoryId(jsonObject.getLong(key));
				break;
			case "productActive":
				product.setProductActive(jsonObject.getBoolean(key));
				break;
			case "quantityWeight":
				product.setQuantityWeight(jsonObject.getString(key));
				break;
			case "price":
				product.setPrice(jsonObject.getString(key));
				break;
			case "productLocation":
				product.setProductLocation(jsonObject.getString(key));
				break;
			case "tags":
				product.setTags(jsonObject.getString(key));
				break;
			default:
				break;
			}
		}
		return product;
	}
}