package com.niit.mycartbackendproject.dao;

import java.util.List;

import com.niit.mycartbackendproject.model.User;

public interface UserDAO {
	public List<User> list();

	public User get(int id);
	

	public void saveOrUpdate(User user);

	public void delete(int id);
	
	public boolean isValidUser(String name,String password);
	
	public boolean admin(String name,String password);
	
	
	

	

}
