package com.niit.bestbuyfrontend.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.bestbuy.dao.CategoryDAO;
import com.niit.bestbuy.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addCategory(@RequestParam("categoryName") String categoryName, @RequestParam("categoryDesc") String categoryDesc)
	{
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.add(category);
		return "Category";
	}
}
