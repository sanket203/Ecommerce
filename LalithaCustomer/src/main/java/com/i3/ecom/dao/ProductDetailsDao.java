package com.i3.ecom.dao;

import java.util.List;

import com.i3.ecom.model.Product;

/**
 * This class will handle all ORM activity against ProductDto and Categories.
 * 
 * @author Sumant
 *
 */
public interface ProductDetailsDao {

	
	/**
	 * This method will return product details on the basis of product id.
	 * @param productId
	 * @return
	 */
	public Product getProductById(final long productId) throws Exception;
	
	/**
	 * This method will return product details on the basis of product name.
	 * @param productName
	 * @return
	 */
	public Product getProductByName(final String productName) throws Exception;
	
	/**
	 * This method will return all product details belongs to a category.
	 * @param category_id
	 * @return
	 */
	public List<Product> getAllProductsByCategory(final long categoryId) throws Exception;
	
	
}
