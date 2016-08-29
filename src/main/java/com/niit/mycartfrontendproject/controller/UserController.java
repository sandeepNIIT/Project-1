package com.niit.mycartfrontendproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.niit.mycartbackendproject.dao.CategoryDAO;
import com.niit.mycartbackendproject.dao.LoginDAO;
import com.niit.mycartbackendproject.dao.RegisterDAO;

import com.niit.mycartbackendproject.model.Category;
import com.niit.mycartbackendproject.model.Login;
import com.niit.mycartbackendproject.model.Register;

@Controller
public class UserController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	
	
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	private Login login;
	
	@Autowired
	private Register register;
	
	
	@Autowired
	private RegisterDAO registerDAO;
	
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password, HttpSession session) {
		

	
		ModelAndView mv = new ModelAndView("Home");
		boolean isValidUser = loginDAO.isValidUser(name, password);

		if (isValidUser == true) {
			if(login.isStatus()==true){
			       session.setAttribute("loggedInUser", name);
			       if (login.getRole()=="ROLE_ADMIN") {
				    mv.addObject("isAdmin", "true");
			}
			

			}
			} else {

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials.Please enter with a valid Credentials");
			

		}
		
		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("/Home");
		session.invalidate();
		
		mv.addObject("display", true);
		mv.addObject("logoutMessage", "You are successfully logged out");
		mv.addObject("loggedOut", "true");
	
		return mv;
	 }
}
