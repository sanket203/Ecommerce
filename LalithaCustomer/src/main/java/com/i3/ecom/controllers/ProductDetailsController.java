
package com.i3.ecom.controllers;


import static com.i3.ecom.utils.URLConstants.GET_CATEGORIES_URL;
import static com.i3.ecom.utils.URLConstants.GET_PRODUCTS_URL;
import static com.i3.ecom.utils.URLConstants.GET_SINGLE_PRODUCT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.i3.ecom.service.ProductDetailsService;
import com.i3.ecom.utils.ResponseMessage;

@Controller
public class ProductDetailsController {
 
	@Autowired
	private ProductDetailsService productDetailsService;
	
	
	@RequestMapping(value=GET_CATEGORIES_URL,method=RequestMethod.GET)
	public @ResponseBody ResponseMessage getAllCategories(){
		ResponseMessage response = productDetailsService.getAllCategories();
		return response;
	}
	
	@RequestMapping(value=GET_PRODUCTS_URL,method=RequestMethod.GET)
	public @ResponseBody ResponseMessage getAllProductsInCategory(@RequestParam("categoryId") String categoryId){
		ResponseMessage response = productDetailsService.getProductsByCategory(categoryId);
		return response;
	}
	
	@RequestMapping(value=GET_SINGLE_PRODUCT,method=RequestMethod.GET)
	public @ResponseBody ResponseMessage getSingleProduct(@RequestParam("categoryId") String categoryId,@RequestParam("productId") String productId){
		ResponseMessage response = productDetailsService.getSingleProduct(categoryId,productId);
		return response;
	}
	
	
	
}
