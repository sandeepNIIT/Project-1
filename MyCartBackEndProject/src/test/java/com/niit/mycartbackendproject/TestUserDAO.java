package com.niit.mycartbackendproject;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mycartbackendproject.dao.UserDAO;
import com.niit.mycartbackendproject.model.User;

import junit.framework.TestCase;

public class TestUserDAO extends TestCase {
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;
	AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
	}

	@Test
	public void UsersTestCase() {
		int size = userDAO.list().size();
		assertEquals("User list test case", 5, size);
	}

	@Test
	public void UserNameTestCase() {
		user = userDAO.get("NIIT");
		String name = user.getName();
		assertEquals("Name test case", "niit", name);
	}
}
