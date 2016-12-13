package com.niit.todolist.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.todolist.dao.UserDAO;
import com.niit.todolist.model.UserDetails;
import com.niit.todolist.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public void addUser(UserDetails userDetails) {
		userDAO.addUser(userDetails);

	}

	public void updateUser(UserDetails userDetails) {
		userDAO.updateUser(userDetails);

	}

	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);

	}

	public List<UserDetails> getUserList() {
		return userDAO.getUserList();
	}

}