package com.i3.ecom.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.i3.ecom.dao.ProductDetailsDao;
import com.i3.ecom.model.Product;

@Component
public class ProductDetailsDaoImpl implements ProductDetailsDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public Product getProductById(final long productId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Product product = null;
		try{
			Transaction tr = session.beginTransaction();
			Query selectQuery = session.createQuery("from Product where productId = :productId");
	        selectQuery.setLong("productId", productId);
			product = (Product)selectQuery.uniqueResult();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return product;
	}

	@Override
	public Product getProductByName(final String productName)throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Product product = null;
		try{
			Transaction tr = session.beginTransaction();
			Query selectQuery = session.createQuery("from Product where productName = :productName");
	        selectQuery.setString("productName", productName);
			product = (Product)selectQuery.uniqueResult();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return product;
	}

	
	@Override
	public List<Product> getAllProductsByCategory(final long categoryId)throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = new ArrayList<Product>();
		try{
			Transaction tr = session.beginTransaction();
			Query selectQuery = session.createQuery("from Product where categoryId = :categoryId");
			selectQuery.setLong("categoryId", categoryId);
			products = selectQuery.list();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return products;
	}

	}
