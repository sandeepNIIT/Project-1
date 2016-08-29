package com.niit.mycartbackendproject.dao;

import java.util.List;

import com.niit.mycartbackendproject.model.Login;

public interface LoginDAO {
	 public List<Login> list();

		public Login get(int id);

		
		
		public void save(Login login);
		public void Update(Login login);

		public void delete(int id);
		
		public boolean isValidUser(String name, String password);
}
