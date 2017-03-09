package com.i3.ecom.service.impl;

import static com.i3.ecom.utils.URLConstants.FAIL_STATUS;
import static com.i3.ecom.utils.URLConstants.INVALID_CREDENTIAL;
import static com.i3.ecom.utils.URLConstants.SUCCESS_STATUS;
import static com.i3.ecom.utils.URLConstants.USER_EXIST;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.i3.ecom.dao.CustomerDao;
import com.i3.ecom.model.Customer;
import com.i3.ecom.service.CustomerService;
import com.i3.ecom.utils.CustomerValidation;
import com.i3.ecom.utils.ResponseMessage;

@Service(value= CustomerServiceImpl.SERVICE_NAME)
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	public static final String SERVICE_NAME = "CustomerServiceImpl";
	
	public ResponseMessage addCustomer(Customer customer) {
		
		String message = null;
		ResponseMessage responseMessage = null;
		try {
			 CustomerValidation.validateCustomer(customer);
			 Customer customerExist = customerDao.getByCustomerByEmail(customer.getEmailId());
			 if(customerExist == null) {
				 customer.setCreationDate(new Date());
				 customer.setModificationDate(new Date());
				 message = customerDao.addCustomer(customer);
				 responseMessage = new ResponseMessage(SUCCESS_STATUS, message);
			 } else {
				 responseMessage = new ResponseMessage(FAIL_STATUS, USER_EXIST);
			 }
		} catch (Exception e) {
			responseMessage = new ResponseMessage(FAIL_STATUS, e.getCause().getMessage());
		}
		return responseMessage;
	}

	@Override
	public ResponseMessage checkUser(String emailId, String password) {
        Customer customer = new Customer();
        ResponseMessage responseMessage = null;
        try {
        	 CustomerValidation.validateData(emailId);
        	 CustomerValidation.validateData(emailId);
        	 customer = customerDao.getCheckedCustomer(emailId, password);
        	 if(customer == null){
        		 responseMessage = new ResponseMessage(FAIL_STATUS, INVALID_CREDENTIAL);
        	 } else {
        		 responseMessage = new ResponseMessage(SUCCESS_STATUS, customer, null);
        	 }
        } catch(Exception e) {
			responseMessage = new ResponseMessage(FAIL_STATUS, e.getCause().getMessage());
		}
		return responseMessage;
	}

}
