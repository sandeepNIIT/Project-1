package com.niit.mycartfrontendproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.mycartbackendproject.dao.LoginDAO;
import com.niit.mycartbackendproject.dao.RegisterDAO;
import com.niit.mycartbackendproject.model.Category;
import com.niit.mycartbackendproject.model.Login;
import com.niit.mycartbackendproject.model.Register;

public class UsersController {
	@Autowired
	private Register register;
	
	
	@Autowired
	private RegisterDAO registerDAO;
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	private Login login;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		
	
		model.addAttribute("userList", this.registerDAO.list());
		model.addAttribute("isAdminClickedUsers", "true");
		return "Home";
	}

	
	@ModelAttribute("register")
	public Register Reg()
	{
		return new Register();
	}
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("register") Register register) {

		
		
		registerDAO.saveOrUpdate(register);
		
	
		return "redirect:/users";
		

	}

	@RequestMapping("user/remove/{id}")
	public String removeUser(@PathVariable("id") int id, ModelMap model) throws Exception {

		try {
			registerDAO.delete(id);
			
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
	
		return "redirect:/users";
	}

	@RequestMapping("user/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("user", this.registerDAO.get(id));
		model.addAttribute("userList", this.registerDAO.list());
		

		return "redirect:/users";
	}

	

	

	

	
	
	
	
	
}
