package com.niit.mycartbackendproject.dao;

import java.util.List;

import com.niit.mycartbackendproject.model.Register;

public interface RegisterDAO {
	 public List<Register> list();

		public Register get(int id);

		
		public void saveOrUpdate(Register register);

		public void delete(int id);
		
		public boolean isValidUser(String name, String password);

}
