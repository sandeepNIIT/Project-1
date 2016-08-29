package com.niit.mycartbackendproject.dao;

import java.util.List;

import com.niit.mycartbackendproject.model.Category;

public interface CategoryDAO {
	public List<Category> list();

	public Category get(int id);
	
	public Category getByName(String name);

	public void saveOrUpdate(Category category);

	public void delete(int id);

}
