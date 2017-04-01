package com.i3.ecom.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.i3.ecom.dao.OrderDetailsDao;
import com.i3.ecom.model.OrderDetails;
@Component
public class OrderDetailsDaoImpl implements OrderDetailsDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<OrderDetails> getOrderDetailsById(String orderDetailsId) {
		Session session = sessionFactory.getCurrentSession();
		 List<OrderDetails> orderDetailList = new ArrayList<OrderDetails>();
	      try{
	    	  Transaction transaction = session.beginTransaction();
	    	  String selectQuery = "from OrderDetails where orderDetailsId= :orderDetailsId"; 
	    	  Query query = session.createQuery(selectQuery);
	    	  query.setString("orderDetailsId", orderDetailsId);
	          orderDetailList = query.list();
	          transaction.commit();
	      } finally {
	    	  if(session.isOpen()){
				session.close();
			  }
	      }
	      return orderDetailList;
	}

	@Override
	public void updateOrderDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		
	}

}
