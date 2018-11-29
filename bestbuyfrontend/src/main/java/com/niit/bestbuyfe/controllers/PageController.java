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
	
	@RequestMapping(value="/product")
	public String showProduct()
	{
		return "Product";
	}
	
	@RequestMapping(value="/supplier")
	public String showSupplier()
	{
		return "Supplier";
	}
	
	@RequestMapping(value="/home")
	public String showHome()
	{
		return "index";
	}
	
	@RequestMapping(value="/test")
	public String showTest()
	{
		return "test";
	}
	
	@RequestMapping(value="/test2")
	public String showTest2()
	{
		return "test2";
	}
}
