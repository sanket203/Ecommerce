package com.i3.ecom.service;

import com.i3.ecom.model.Customer;
import com.i3.ecom.utils.ResponseMessage;

public interface CustomerService {
	
	ResponseMessage addCustomer(final Customer customer);

	ResponseMessage checkUser(final String emailId, final String password);
}
