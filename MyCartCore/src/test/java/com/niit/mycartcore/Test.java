package com.niit.mycartcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.mycartcore");
		context.refresh();
		
		 Category c =(Category) context.getBean("category");
		 c.setId("ITM001");
		 c.setName("Laptop");
		 System.out.println(c.getId());
		 System.out.println(c.getName());
		 
		
		
		Product p =(Product) context.getBean("product");
		p.setId("ITM002");
		p.setName("Smartphone");
		p.setPrice(50000);
		 System.out.println(p.getId());
		 System.out.println(p.getName());
		 System.out.println(p.getPrice());
		
	}

}
