package com.i3.ecom.dto;

public class ProductDto {
	
	long productId;
	
	String productName;
	
	String description;
	
	long categoryId;
	 
	String addedBy;
	
	boolean productActive;
	
	String tags;
	
	double price;
	
	String quantityWeight;
	
	String imageUrl ;
	
	String productLocation;
	
	String imageFileName; 
	

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantityWeight() {
		return quantityWeight;
	}

	public void setQuantityWeight(String quantityWeight) {
		this.quantityWeight = quantityWeight;
	}

	public String getProductLocation() {
		return productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return description;
	}

	public void setProductDescription(String productDescription) {
		this.description = productDescription;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public boolean isProductActive() {
		return productActive;
	}

	public void setProductActive(boolean productActive) {
		this.productActive = productActive;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getQuantityinWeight(String quantityinWeight) {
		return quantityinWeight;
	}

	public void setQuantityinWeight(String quantityinWeight) {
		this.quantityWeight = quantityinWeight;
	}
	
	

}
