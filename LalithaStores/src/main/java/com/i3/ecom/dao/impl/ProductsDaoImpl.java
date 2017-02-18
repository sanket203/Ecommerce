package com.i3.ecom.dao.impl;

import static com.i3.ecom.utils.UserConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.i3.ecom.dao.ProductsDao;
import com.i3.ecom.model.Category;
import com.i3.ecom.model.Product;

@Component
public class ProductsDaoImpl implements ProductsDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String addProduct(final Product product) throws Exception {
      Session session = sessionFactory.getCurrentSession();
      try{
    	  Transaction transaction = session.beginTransaction();
          session.save(product);
          transaction.commit();
      } finally {
    	  if(session.isOpen()){
				session.close();
			}
      }
      return PRODUCT_ADD;
	}

	@Override
	public String addCategory(final Category category) throws Exception {
		 Session session = sessionFactory.getCurrentSession();
	      try{
	    	  Transaction transaction = session.beginTransaction();
	  		  session.save(category);
	  		  transaction.commit();
	      } finally {
	    	  if(session.isOpen()){
					session.close();
				}
	      }
		return CATEGORY_ADD;
	}

	@Override
	public Category getCategoryByName(final String categoryName)throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Category category = null;
		try{
			Transaction tr = session.beginTransaction();
			Query selectQuery = session.createQuery("from Category where categoryName = :categoryName");
	        selectQuery.setString("categoryName", categoryName);
			category = (Category)selectQuery.uniqueResult();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return category;
	}

	@Override
	public Category getCategoryById(final long categoryId) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Category category = null;
		try{
			Transaction tr = session.beginTransaction();
			Query selectQuery = session.createQuery("from Category where categoryId = :categoryId");
	        selectQuery.setLong("categoryId", categoryId);
			category = (Category)selectQuery.uniqueResult();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return category;
	}

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
	public List<Category> getAllCategories()throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Category> categories = new ArrayList<Category>();
		try{
			Transaction tr = session.beginTransaction();
			Query selectQuery = session.createQuery("from Category");
			categories = selectQuery.list();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return categories;
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

	@Override
	public String deleteCategory(long categoryId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Transaction transaction = session.beginTransaction();
			Category category = new Category();
			category.setCategoryId(categoryId);
			session.delete(category);
			transaction.commit();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return CATEGORY_DELTE;
	}

	@Override
	public String deleteProduct(long productId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Transaction transaction = session.beginTransaction();
			Product product = new Product();
			product.setProductId(productId);
			session.delete(product);
			transaction.commit();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return PRODUCT_DELETE;
	}

	@Override
	public void deleteAllProduct(long categoryId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Transaction tr = session.beginTransaction();
			Query deleteQuery = session.createQuery("delete Product where categoryId = :categoryId");
			deleteQuery.setLong("categoryId", categoryId);
			deleteQuery.executeUpdate();
			tr.commit();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
	}

	@Override
	public String updateProduct(Product product) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try{
			Transaction transaction = session.beginTransaction();
			session.update(product);
			transaction.commit();
		} finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return PRODUCT_UPDATE;
	}
}
