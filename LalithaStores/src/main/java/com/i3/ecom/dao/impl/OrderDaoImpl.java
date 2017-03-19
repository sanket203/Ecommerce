package com.i3.ecom.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.i3.ecom.dao.OrderDao;
import com.i3.ecom.model.Customer;
import com.i3.ecom.model.Order;
import com.i3.ecom.model.Product;
import com.i3.ecom.pojo.Address;

public class OrderDaoImpl implements OrderDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Order> getOrdersByDate() {
	 Session session = sessionFactory.getCurrentSession();
	 List<Order> orderList = new ArrayList<Order>();
      try{
    	  Transaction transaction = session.beginTransaction();
    	  String selectQuery = " SELECT * FROM Orders o where o.orderDate BETWEEN  DATE_SUB(current_date(), INTERVAL 7 DAY) AND current_date()"; 
    	  Query query = session.createSQLQuery(selectQuery);
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
    	  String selectQuery = "from Orders where status= :status";
    	  Query query = session.createQuery(selectQuery);
    	  query.setString("status", status);
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
	public Order getOrderByOrderDetailId(String orderDetailId) {
	 Session session = sessionFactory.getCurrentSession();
	 Order order = new Order();
      try{
    	  Transaction transaction = session.beginTransaction();
    	  String selectQuery = "from Orders where orderDetailsId= :orderDetailsId";
    	  Query query = session.createQuery(selectQuery);
    	  query.setString("orderDetailsId", orderDetailId);
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
	public List<Product> getOrderedProducts(List<Long> productsIds) {
		Session session = sessionFactory.getCurrentSession();
		 List<Product> orderedProducts = new LinkedList<Product>();
	      try{
	    	  Transaction transaction = session.beginTransaction();
	    	  String selectQuery = "SELECT * FROM Product p WHERE p.productId IN :productsIds"; 
	    	  Query query = session.createQuery(selectQuery);
	    	  query.setParameter("productsId", productsIds);
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
	    	  String selectQuery = "SELECT * FROM Address a WHERE a.addressId= :addressId"; 
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
