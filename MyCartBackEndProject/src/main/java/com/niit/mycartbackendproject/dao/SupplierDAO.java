package com.niit.mycartbackendproject.dao;

import java.util.List;

import com.niit.mycartbackendproject.model.Category;
import com.niit.mycartbackendproject.model.Supplier;

public interface SupplierDAO {
	public List<Supplier> list();
	public Supplier get(String id);
	public void saveOrUpdate(Supplier supplier);
	public void delete(String id);
	
	
	

}
