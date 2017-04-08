
package com.i3.ecom.controllers;

import static com.i3.ecom.utils.URLConstants.ADD_CATEGORY_URL;
import static com.i3.ecom.utils.URLConstants.ADD_PRODUCT_URL;
import static com.i3.ecom.utils.URLConstants.DELETE_CATEGORY_URL;
import static com.i3.ecom.utils.URLConstants.DELETE_PRODUCT;
import static com.i3.ecom.utils.URLConstants.GET_CATEGORIES_URL;
import static com.i3.ecom.utils.URLConstants.GET_PRODUCTS_URL;
import static com.i3.ecom.utils.URLConstants.UPDATE_PRODUCTS_URL;
import static com.i3.ecom.utils.URLConstants.UPDATE_CATEGORY_URL;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.i3.ecom.model.Category;
import com.i3.ecom.model.Product;
import com.i3.ecom.service.ProductService;
import com.i3.ecom.utils.ResponseMessage;

@Controller
public class ProductController {
 
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value=ADD_PRODUCT_URL,method=RequestMethod.POST, consumes={"multipart/form-data"})
	public @ResponseBody ResponseMessage addProduct(@RequestParam("productJson") String productJson, 
			                               @RequestParam List< MultipartFile> imageFile,
			                               Model model){
		ResponseMessage message = productService.addProduct(productJson,imageFile);
		return message;
	}
	
	@RequestMapping(value=ADD_CATEGORY_URL,method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseMessage addCategory(@RequestBody final Category categoryJson){
		ResponseMessage message = productService.addCategory(categoryJson);
		return message;
	}
	
	@RequestMapping(value=GET_CATEGORIES_URL,method=RequestMethod.GET)
	public @ResponseBody ResponseMessage getAllCategories(){
		ResponseMessage response = productService.getAllCategories();
		return response;
	}
	
	@RequestMapping(value=GET_PRODUCTS_URL,method=RequestMethod.GET)
	public @ResponseBody ResponseMessage getAllProductsInCategory(@RequestParam("categoryId") String categoryId){
		ResponseMessage response = productService.getProductsByCategory(categoryId);
		return response;
	}
	
	@RequestMapping(value=UPDATE_PRODUCTS_URL,method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody ResponseMessage updateProduct(@RequestBody Product productJson){
		ResponseMessage response = productService.updateProduct(productJson);
		return response;
	}
	
	@RequestMapping(value=DELETE_PRODUCT,method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody ResponseMessage deleteProduct(@RequestBody Product productJson){
		ResponseMessage response = productService.removeProduct(productJson);
		return response;
	}
	
	@RequestMapping(value=DELETE_CATEGORY_URL,method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody ResponseMessage deleteCategory(@RequestBody Category category){
		ResponseMessage response = productService.removeCategory(category.getCategoryId());
		return response;
	}
	
	@RequestMapping(value=UPDATE_CATEGORY_URL,method=RequestMethod.POST,consumes="application/json")
	public @ResponseBody ResponseMessage updateCategory(@RequestBody Category category){
		ResponseMessage response = productService.updateCategory(category);
		return response;
	}
}
