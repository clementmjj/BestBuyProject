package com.niit.bestbuyfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.bestbuy.dao.CategoryDAO;
import com.niit.bestbuy.model.Category;

@Controller
public class PageController 
{	
	@Autowired
	CategoryDAO categoryDAO;
	
	@ModelAttribute("categoryList")
	public List<Category> getCategoryList()
	{			
		List<Category> categoryList=categoryDAO.listCategories();
		return categoryList;
	}
	
	@RequestMapping(value="/aboutus")
	public String showAboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping(value="/test")
	public String showTest()
	{
		return "test";
	}
}
