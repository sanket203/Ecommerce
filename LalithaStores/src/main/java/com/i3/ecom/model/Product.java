package com.i3.ecom.model;

import static com.i3.ecom.utils.UserConstants.ADDED_BY;
import static com.i3.ecom.utils.UserConstants.CATEGORY_ID;
import static com.i3.ecom.utils.UserConstants.DESCRIPTION;
import static com.i3.ecom.utils.UserConstants.PRICE;
import static com.i3.ecom.utils.UserConstants.PRODUCT_ACTIVE;
import static com.i3.ecom.utils.UserConstants.PRODUCT_ID;
import static com.i3.ecom.utils.UserConstants.PRODUCT_LOCATION;
import static com.i3.ecom.utils.UserConstants.PRODUCT_NAME;
import static com.i3.ecom.utils.UserConstants.QUANTITY_STOCK;
import static com.i3.ecom.utils.UserConstants.QUANTITY_WEIGHT;
import static com.i3.ecom.utils.UserConstants.TAGS;
import static com.i3.ecom.utils.UserConstants.DEFAULT_IMAGE;

import java.util.Date;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

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
	
	@Column(name="quantity_stock")
	private String quantityStock;
	
	@Column(name="addedBy")
	private String addedBy;
	
	@Transient
	private String dateAdded;
	
	@Transient
	private Long addedByUserId;
	
	public String getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(String quantityStock) {
		this.quantityStock = quantityStock;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
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
			case PRODUCT_ID:
				product.setProductId(jsonObject.getLong(key));
				break;
			case PRODUCT_NAME:
				product.setProductName(jsonObject.getString(key));
				break;
			case DESCRIPTION:
				product.setDescription(jsonObject.getString(key));
				break;
			case CATEGORY_ID:
				product.setCategoryId(jsonObject.getLong(key));
				break;
			case PRODUCT_ACTIVE:
				product.setProductActive(jsonObject.getBoolean(key));
				break;
			case QUANTITY_WEIGHT:
				product.setQuantityWeight(jsonObject.getString(key));
				break;
			case PRICE:
				product.setPrice(jsonObject.getString(key));
				break;
			case PRODUCT_LOCATION:
				product.setProductLocation(jsonObject.getString(key));
				break;
			case TAGS:
				product.setTags(jsonObject.getString(key));
				break;
			case ADDED_BY:
				product.setAddedBy(jsonObject.getString(key));
				break;
			case QUANTITY_STOCK:
				product.setQuantityStock(jsonObject.getString(key));
				break;
<<<<<<< HEAD
=======
			case DEFAULT_IMAGE:
				product.setAddedBy(jsonObject.getString(key));
				break;
>>>>>>> refs/remotes/origin/master
			default:
				break;
			}
		}
		return product;
	}

	/**
	 * @return the addedByUserId
	 */
	public Long getAddedByUserId() {
		return addedByUserId;
	}

	/**
	 * @param addedByUserId the addedByUserId to set
	 */
	public void setAddedByUserId(Long addedByUserId) {
		this.addedByUserId = addedByUserId;
	}
}