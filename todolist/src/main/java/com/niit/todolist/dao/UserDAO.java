package com.niit.todolist.dao;

import java.util.List;

import com.niit.todolist.model.UserDetails;

public interface UserDAO {

	public void addUser(UserDetails userDetails);
	
	public void updateUser(UserDetails userDetails);
	
	public void deleteUser(int userId);
	
	public List<UserDetails> getUserList();
}
