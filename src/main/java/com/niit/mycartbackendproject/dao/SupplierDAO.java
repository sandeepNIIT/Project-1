package com.niit.mycartbackendproject.dao;

import java.util.List;

import com.niit.mycartbackendproject.model.Supplier;

public interface SupplierDAO {
	public List<Supplier> list();

	public Supplier get(int id);
	
	public Supplier getByName(String name);

	public void saveOrUpdate(Supplier supplier);

	public String delete(int id);

}
