package com.i3.ecom.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.i3.ecom.model.Category;
import com.i3.ecom.model.Product;
import com.i3.ecom.utils.ResponseMessage;

/**
 * This service is use to manage all product and category related activity.
 * @author Sumant
 *
 */
public interface ProductService {

	/**
	 * This method is used to add product and product images.
	 * @param productJson
	 * @param imageFile
	 * @return
	 */
	public ResponseMessage addProduct(String productJson, final List<MultipartFile> imageFile);
	
	/**
	 * This method is used to save category.
	 * @param categoryJson
	 * @return
	 */
	public ResponseMessage addCategory(Category categoryJson);
	
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
	
	/**
	 * This method will delete category on the basis of category id. 
	 * Before deletion of category it looks for all products belongs to this category and remove them first. Then delete category.
	 * @param category_id
	 * @return
	 */
	public ResponseMessage removeCategory(final long l);
	
	/**
	 * This method will delete product on the basis of product id
	 * @param productId
	 * @return
	 */
	public ResponseMessage removeProduct(final Product product);
	
	/**
	 * This method will delete all products belongs to category id.
	 * @param categoryId
	 * @return
	
	public ResponseMessage removeAllProduct(final String categoryId); */
	
	public ResponseMessage updateProduct(final Product product);
	
}
