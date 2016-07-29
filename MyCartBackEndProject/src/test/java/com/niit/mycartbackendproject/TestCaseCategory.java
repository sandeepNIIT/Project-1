package com.niit.mycartbackendproject;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mycartbackendproject.dao.CategoryDAO;
import com.niit.mycartbackendproject.model.Category;

public class TestCaseCategory {

	@Autowired
	static CategoryDAO categoryDAO;
	@Autowired
	static Category category;
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		category =(Category) context.getBean("category");
		
	}
	
	@Test
	public void CategoryNameTest()
	{
		category = categoryDAO.get("CG001");
		String name = category.getName();
		assertEquals("Category Name Test","CG001",name);
		
	}
}
