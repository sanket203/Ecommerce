package com.i3.ecom.dao;

import java.util.List;

import com.i3.ecom.model.Category;
import com.i3.ecom.model.Product;

/**
 * This class will handle all ORM activity against Product and Categories.
 * 
 * @author Sumant
 *
 */
public interface ProductsDao {

	/**
	 * This method will save category to database.
	 * @param category
	 * @return
	 * @throws Exception
	 */
	public String addCategory(final Category category) throws Exception;
	
	/**
	 * This method will add product to database.
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public String addProduct(final Product product) throws Exception;
	
	/**
	 * This method will return category details on the basis of category name.
	 * @param name
	 * @return
	 */
	public Category getCategoryByName(final String categoryName) throws Exception;
	
	/**
	 * This method will return category details on the basis of category id.
	 * @param category_id
	 * @return
	 */
	public Category getCategoryById(final long categoryId) throws Exception;
	
	/**
	 * This method will return list of all existing categories.
	 * @return
	 */
	public List<Category> getAllCategories() throws Exception;
	
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
	
	/**
	 * This method will delete category on the basis of category id. 
	 * Before deletion of category it looks for all products belongs to this category and remove them first. Then delete category.
	 * @param category_id
	 * @return
	 */
	public String deleteCategory(final long category);
	
	/**
	 * This method will delete product on the basis of product id
	 * @param productId
	 * @return
	 */
	public String deleteProduct(final long productId);
	
	/**
	 * This method will delete all products belobngs to category id.
	 * @param categoryId
	 * @return
	 */
	public void deleteAllProduct(final long categoryId);
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	public String updateProduct(final Product product) throws Exception;
	
}
