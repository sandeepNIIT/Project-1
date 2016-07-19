package com.niit.mycart;

import java.util.ArrayList;

public class Testing {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<Product>();
	Product p = new Product("ITM001","Laptop",80000,"Electronics");
	list.add(p);
	p = new Product("ITM002","Smartphone",18000,"Electronics");
	list.add(p);
	p = new Product("ITM003","Speakers",30000,"Electronics");
	list.add(1,p);
	for(Product prd:list)
	{
	System.out.println(prd.getId());
	System.out.println(prd.getName());
	System.out.println(prd.getPrice());
	System.out.println(prd.getCategory());
	}
	}
}
