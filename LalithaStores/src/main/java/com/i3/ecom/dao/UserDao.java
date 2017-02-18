package com.i3.ecom.dao;

import java.util.List;

import com.i3.ecom.model.Users;

public interface UserDao {
	
	public String addUser(final Users users) throws Exception;
	
	public String editUser(final Users users) throws Exception;
	
	public String deleteUser(final String users) throws Exception;
	
	public List<Users> getAllUsers() throws Exception;
	
	public Users getUser(final String userJson) throws Exception;

}
