package com.niit.todolist.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = {"/"})
	public ModelAndView onLoad(HttpSession session) {

		ModelAndView mv = new ModelAndView("/home");

		return mv;

	}

}
