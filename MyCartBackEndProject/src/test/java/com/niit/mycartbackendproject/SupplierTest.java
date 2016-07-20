package com.niit.mycartbackendproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mycartbackendproject.dao.SupplierDAO;
import com.niit.mycartbackendproject.model.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.mycartbackendproject");
		context.refresh();

		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		Supplier supplier = (Supplier) context.getBean("supplier");
		supplier.setId("SUP120");
		supplier.setName("SUPName120");
		supplier.setAddress("Chennai");

		supplierDAO.saveOrUpdate(supplier);

		

	}

}
