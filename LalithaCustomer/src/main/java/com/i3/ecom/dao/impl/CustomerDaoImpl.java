package com.i3.ecom.dao.impl;

import static com.i3.ecom.utils.Constants.CUSTOMER_ADDED;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.i3.ecom.dao.CustomerDao;
import com.i3.ecom.model.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public String addCustomer(Customer customer) throws Exception {
		 Session session = sessionFactory.getCurrentSession();
		 try{
	         Transaction transaction = session.beginTransaction();
	         session.save(customer);
	         transaction.commit();
		 }finally{
			if(session.isOpen()){
				session.close();
			}
		 }
		return CUSTOMER_ADDED;
	}

	@Override
	public Customer getCheckedCustomer(String emailId, String password)throws Exception {
		Customer customer = new Customer();
		Session session = sessionFactory.getCurrentSession();
		try {
			 Transaction transaction = session.beginTransaction();
             Query selectQuery = session.createQuery("from Customer where emailId = :emailId and password = :password");
             selectQuery.setString("emailId", emailId);
             selectQuery.setString("password", password);
             customer = (Customer)selectQuery.uniqueResult();
             transaction.commit();
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
		return customer;
	}

	@Override
	public Customer getByCustomerByEmail(String emailId) throws Exception {
		Customer customer = new Customer();
		Session session = sessionFactory.getCurrentSession();
		try {
			 Transaction transaction = session.beginTransaction();
             Query selectQuery = session.createQuery("from Customer where emailId = :emailId");
             selectQuery.setString("emailId", emailId);
             customer = (Customer)selectQuery.uniqueResult();
             transaction.commit();
		} finally {
			if(session.isOpen()) {
				session.close();
			}
		}
		return customer;
	}
	
}
