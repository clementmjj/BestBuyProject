package com.niit.bestbuyfe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
	@RequestMapping(value="/login")
	public String showLogin()
	{
		return "Login";
	}
	
	@RequestMapping(value="/register")
	public String showRegister()
	{
		return "Register";
	}
	
	@RequestMapping(value="/aboutus")
	public String showAboutUs()
	{
		return "AboutUs";
	}
}
