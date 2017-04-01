package com.i3.ecom.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.i3.ecom.dao.OrderDao;
import com.i3.ecom.model.Customer;
import com.i3.ecom.model.Order;
import com.i3.ecom.model.Product;
import com.i3.ecom.pojo.Address;
@Component
public class OrderDaoImpl implements OrderDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrdersByDate() {
	 Session session = sessionFactory.getCurrentSession();
	 List<Order> orderList = new ArrayList<Order>();
      try{
    	  Transaction transaction = session.beginTransaction();
    	  String selectQuery = "SELECT * FROM `order` WHERE `orderDate` >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)"; 
    	  Query query = session.createSQLQuery(selectQuery).addEntity(Order.class);
    	  orderList = query.list();
          transaction.commit();
      } finally {
    	  if(session.isOpen()){
			session.close();
		  }
      }
      return orderList;
	}

	@Override
	public List<Order> getOrderByStatus(String status) {
	 Session session = sessionFactory.getCurrentSession();
	 List<Order> orderList = new ArrayList<Order>();
      try{
    	  Transaction transaction = session.beginTransaction();
    	  String selectQuery = "SELECT * FROM `order` WHERE `status` = '"+ status+"'"; 
    	  Query query = session.createSQLQuery(selectQuery).addEntity(Order.class);
    	  orderList = query.list();
          transaction.commit();
      } finally {
    	  if(session.isOpen()){
			 session.close();
		  }
      }
      return orderList;
	}

	@Override
	public Order getOrderByOrderDetailId(String orderDetailsId) {
	 Session session = sessionFactory.getCurrentSession();
	 Order order = new Order();
      try{
    	  Transaction transaction = session.beginTransaction();
    	  String selectQuery = "SELECT * FROM `order` WHERE `orderDetailsId` = '"+ orderDetailsId+"'"; 
    	  Query query = session.createSQLQuery(selectQuery).addEntity(Order.class);
          order = (Order)query.uniqueResult();
          transaction.commit();
      } finally {
		  if(session.isOpen()){
			session.close();
		  }
      }
      return order;
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomerById(long customerId) {
		Session session = sessionFactory.getCurrentSession();
		 Customer customer = new Customer();
	      try{
	    	  Transaction transaction = session.beginTransaction();
	    	  String selectQuery = "from Customer where customerId= :customerId";
	    	  Query query = session.createQuery(selectQuery);
	    	  query.setLong("customerId", customerId);
	          customer = (Customer)query.uniqueResult();
	          transaction.commit();
	      } finally {
			  if(session.isOpen()){
				session.close();
			  }
	      }
	      return customer;
	}

	@Override
	public List<Product> getOrderedProducts(List<Long> productId) {
		Session session = sessionFactory.getCurrentSession();
		 List<Product> orderedProducts = new LinkedList<Product>();
	      try{
	    	  Transaction transaction = session.beginTransaction();
	    	  String selectQuery = "SELECT * FROM Product p WHERE p.productId IN (:productId)"; 
	    	  Query query = session.createSQLQuery(selectQuery).addEntity(Product.class);
	    	  query.setParameterList("productId", productId);
	    	  orderedProducts = query.list();
	          transaction.commit();
	      } finally {
	    	  if(session.isOpen()){
				session.close();
			  }
	      }
	      return orderedProducts;
	}

	@Override
	public Address getOrderAddress(long addressId) {
		Session session = sessionFactory.getCurrentSession();
		Address address = new Address();
	      try{
	    	  Transaction transaction = session.beginTransaction();
	    	  String selectQuery = "from Address where addressId= :addressId"; 
	    	  Query query = session.createQuery(selectQuery);
	    	  query.setLong("addressId", addressId);
	    	  address = (Address)query.uniqueResult();
	          transaction.commit();
	      } finally {
	    	  if(session.isOpen()){
				session.close();
			  }
	      }
	      return address;
	}

}
