package com.niit.mycartbackendproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mycartbackendproject.dao.ProductDAO;
import com.niit.mycartbackendproject.model.Product;

public class ProductTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.mycartbackendproject");
		context.refresh();

		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

		Product product = (Product) context.getBean("product");
		product.setId("PRD120");
		product.setName("Samsung s6102");
		product.setDescription("Mobile");
		product.setPrice(20000);

		productDAO.saveOrUpdate(product);

		/*if (productDAO.get("sdfsf") == null) {
			System.out.println("Product does not exist");
		} else {
			System.out.println("Product exist.....the details are..");
			System.out.println();
		}*/

	}

}
