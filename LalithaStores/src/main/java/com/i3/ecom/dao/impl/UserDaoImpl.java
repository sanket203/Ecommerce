package com.i3.ecom.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.i3.ecom.dao.UserDao;
import com.i3.ecom.model.Users;

import static com.i3.ecom.utils.UserConstants.USER_ADDED;
import static com.i3.ecom.utils.UserConstants.USER_UPDATED;
import static com.i3.ecom.utils.UserConstants.USER_DELETED;
@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String addUser(Users users) throws Exception {
		 Session session = sessionFactory.getCurrentSession();
		 try{
	      Transaction transaction = session.beginTransaction();
	      session.save(users);
	      transaction.commit();
		 }finally{
			 if(session.isOpen()){
					session.close();
				}
		 }
	      
		
		return USER_ADDED;
	}

	@Override
	public String editUser(Users users) throws Exception {
		 Session session = sessionFactory.getCurrentSession();
		 try{
	      Transaction transaction = session.beginTransaction();
	      session.update(users);
	      transaction.commit();
		 }finally{
			 if(session.isOpen()){
					session.close();
				}
		 }
		return USER_UPDATED;
	}

	@Override
	public String deleteUser(String emailId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try{
		Transaction transaction = session.beginTransaction();
		Query selectQuery = session.createQuery("delete from users where emailId=:emailId");
		selectQuery.setString("emailId", emailId);
		selectQuery.executeUpdate();
		 transaction.commit();
	 }finally{
		 if(session.isOpen()){
				session.close();
			}
	 }
		return USER_DELETED;
	}

	@Override
	public List<Users> getAllUsers() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Users> users;
		try{
		Transaction transaction = session.beginTransaction();
		Query selectQuery = session.createQuery("from users");
		 users = selectQuery.list();
		 transaction.commit();
	 }finally{
		 if(session.isOpen()){
				session.close();
			}
	 }
		return users;
	}

	@Override
	public Users getUser(String emailId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Users users;
		try{
		Transaction transaction = session.beginTransaction();
		Query selectQuery = session.createQuery("select usr from users usr where usr.emailId=:emailId");
		selectQuery.setString("emailId", emailId);
		 users = (Users) selectQuery.uniqueResult();
		 }finally{
			 if(session.isOpen()){
					session.close();
				}
		 }
		return users;
	}

}
