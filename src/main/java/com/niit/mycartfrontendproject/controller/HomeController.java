package com.niit.mycartfrontendproject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mycartbackendproject.dao.CategoryDAO;
import com.niit.mycartbackendproject.dao.LoginDAO;
import com.niit.mycartbackendproject.dao.RegisterDAO;
import com.niit.mycartbackendproject.model.Category;
import com.niit.mycartbackendproject.model.Login;
import com.niit.mycartbackendproject.model.Register;

@Controller
public class HomeController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private Register register;
	
	@Autowired
	private RegisterDAO registerDAO;
	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	private Login login;
	
	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session) {
	
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("display", true);
		
		
		return mv;
		
	}
	
	@ModelAttribute("register")
	public Register Reg()
	{
		return new Register();
	}
	
	@RequestMapping(value = "userRegistration", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("register") Register register,BindingResult result) {
		registerDAO.saveOrUpdate(register);
		login.setName(register.getName());
		login.setId(register.getId());
		login.setPassword(register.getPassword());
		login.setStatus(register.getStatus());
		loginDAO.save(login);
		register.setRole(login.getRole());
		registerDAO.saveOrUpdate(register);
		ModelAndView mv  = new ModelAndView("/Home");
		mv.addObject("successMessage", "You are successfully registered.Please Login");
		
		return mv;
	}
	
	@RequestMapping("/landing")
	public ModelAndView landing() {
		ModelAndView mv = new ModelAndView("/Home");
		
			mv.addObject("display", "true");
	
		
		
		return mv;
	}
	
	@RequestMapping("/registerHere")
	public ModelAndView registerHere() {
		ModelAndView mv = new ModelAndView("/Home");
	
		mv.addObject("ifClickedRegister", "true");
		return mv;
	}

	@RequestMapping("/loginHere")
	public ModelAndView loginHere() {
		ModelAndView mv = new ModelAndView("/Home");
		
		mv.addObject("ifClickedLogin", "true");
		return mv;
	}
}



