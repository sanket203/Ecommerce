package com.i3.ecom.service.impl;

import static com.i3.ecom.utils.URLConstants.FAIL_STATUS;
import static com.i3.ecom.utils.URLConstants.SUCCESS_STATUS;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.i3.ecom.dao.CustomerDao;
import com.i3.ecom.model.Customer;
import com.i3.ecom.service.CustomerService;
import com.i3.ecom.utils.ResponseMessage;

@Service(value= CustomerServiceImpl.SERVICE_NAME)
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao userDao;
	public static final String SERVICE_NAME = "CustomerServiceImpl";
	
	public ResponseMessage addCustomer(Customer customer) {
		
		String message = null;
		ResponseMessage responseMessage = null;
		try {
		//Users user = Users.getUser(userJson);
			
			message = userDao.addCustomer(customer);
			responseMessage = new ResponseMessage(SUCCESS_STATUS, message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseMessage = new ResponseMessage(FAIL_STATUS, e.getCause().getMessage());
		}
		return responseMessage;
	}

}
