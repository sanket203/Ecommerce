package com.i3.ecom.utils;


import org.apache.commons.lang3.StringUtils;

import com.i3.ecom.model.Category;
import com.i3.ecom.model.Product;

public class ProductValidation {

	public static void validateProduct(Product product) throws Exception {
		try {
			validateData(product.getProductName());
			validateData(product.getProductLocation());
			validateData(product.getPrice());
			validateData(product.getAddedBy());
			
		} catch (Exception e) {
			throw new Exception("One of the mandatoryfield is empty. Please fill all information");
		}
	}
	
	public static void validateCategory(Category category) throws Exception {
		try{
			validateData(category.getCategoryName());
			validateData(category.getAddedBy());
		} catch (Exception ex) {
			throw new Exception("One of the mandatoryfield is empty. Please fill all information");
		}
	
	}
	
	private static void validateData(String data) throws Exception{
		if(StringUtils.isEmpty(data)){
			throw new Exception("One of the mandatoryfield is empty. Please fill all information");
		}
	}
}
