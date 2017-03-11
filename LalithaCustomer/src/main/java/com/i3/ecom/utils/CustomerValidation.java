package com.i3.ecom.utils;

import org.apache.commons.lang3.StringUtils;

import com.i3.ecom.model.Customer;

public class CustomerValidation {

	public static void validateCustomer(final Customer customer) throws Exception{
		try{
			 validateData(customer.getFirstName());
			 validateData(customer.getLastName());
			 validateData(customer.getEmailId());
			 validateData(customer.getPassword());
			 validateData(customer.getGender());
			 validateData(customer.getContact());
		} catch(Exception ex){
	 }
   }
   
	public static void validateData(String data) throws Exception {
		if(StringUtils.isEmpty(data)){
			throw new Exception("One of the mandatoryfield is empty. Please fill all information");
		}
	}
}
