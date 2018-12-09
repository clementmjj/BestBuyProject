package com.niit.bestbuyfe.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.bestbuy.dao.UserDAO;
import com.niit.bestbuy.model.User;

@Controller
public class LoginController 
{
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/login")
	public String showLogin(Model m)
	{
		m.addAttribute("login", new User());
		return "Login";
	}
	
}
