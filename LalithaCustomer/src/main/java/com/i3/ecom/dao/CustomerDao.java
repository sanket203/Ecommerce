package com.i3.ecom.dao;

import com.i3.ecom.model.Customer;


public interface CustomerDao {
	
	/**
	 * Method is used to add customer
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public String addCustomer(final Customer customer) throws Exception;
	
	/**
	 * This method is use to validate and return customer object
	 * @param userName
	 * @param password
	 * @return
	 * @throws exception
	 */
	public Customer getCheckedCustomer(final String emailId, final String password) throws Exception;
	
	/**
	 * get customer by email id to avoid duplication.
	 * @param emailId
	 * @return
	 * @throws Exception
	 */
	public Customer getByCustomerByEmail(final String emailId) throws Exception;
		

}
