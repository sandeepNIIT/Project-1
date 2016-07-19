package com.niit.mycartbackendproject.dao;

import java.util.List;
import java.util.Locale.Category;

public interface CategoryDAO {
	public List<Category> list();
	public Category get(String id);
	public void saveOrUpdate(Category category);
	public void delete(String id);
	
	
	

}
