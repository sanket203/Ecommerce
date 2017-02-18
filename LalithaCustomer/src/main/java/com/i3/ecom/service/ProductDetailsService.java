package com.i3.ecom.service;


import com.i3.ecom.utils.ResponseMessage;

/**
 * This service is use to manage all product and category related activity.
 * @author Sumant
 *
 */
public interface ProductDetailsService {

	
	/**
	 * This method will return a response object with list of all categories. 
	 * @return
	 */
	public ResponseMessage getAllCategories();
	
	/**
	 * This method returns a response with a list of all products belong to category.
	 * @param categoryId
	 * @return
	 */
	public ResponseMessage getProductsByCategory(final String categoryId);
	
	public ResponseMessage getSingleProduct(final String categoryId, final String productId);
	
	
}
