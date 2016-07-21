package com.niit.mycartbackendproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mycartbackendproject.dao.UserDAO;
import com.niit.mycartbackendproject.model.User;

public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.mycartbackendproject");
		context.refresh();

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");

		User user = (User) context.getBean("user");
		user.setId("USR120");
		user.setName("Sandeep");
		user.setPassword("asdf");
		user.setMobileno("8004497845");
		user.setAddress("Hyderabad");
		user.setEmail("sandeepsdp@gmail.com");

		userDAO.saveOrUpdate(user);

		

	}

}
