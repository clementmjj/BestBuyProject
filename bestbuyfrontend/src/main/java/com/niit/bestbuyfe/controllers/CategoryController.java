package com.niit.bestbuyfe.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.bestbuy.dao.CategoryDAO;
import com.niit.bestbuy.dao.ProductDAO;
import com.niit.bestbuy.model.Category;
import com.niit.bestbuy.model.Product;

@Controller
public class CategoryController 
{
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/category")
	public String showCategory(Model m)
	{
		m.addAttribute("categoryList",categoryDAO.listCategories());
		return "Category";
	}
	
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("categoryName")String categoryName,
			@RequestParam("categoryDesc")String categoryDesc,Model m, @Valid Category category, BindingResult result)
	{
		if(result.hasErrors())
		{
			m.addAttribute("errors",true);
			if(result.getFieldErrorCount("categoryName")>0)
			{
				List<String> categoryNameErrorList=new LinkedList<String>();
				for(FieldError fe:result.getFieldErrors("categoryName"))
				{
					categoryNameErrorList.add(fe.getDefaultMessage());
				}
				m.addAttribute("category_name_errors",categoryNameErrorList);
			}
			if(result.getFieldErrorCount("categoryDesc")>0)
			{
				List<String> categoryDescErrorList=new LinkedList<String>();
				for(FieldError fe:result.getFieldErrors("categoryDesc"))
				{
					categoryDescErrorList.add(fe.getDefaultMessage());
				}
				m.addAttribute("category_desc_errors",categoryDescErrorList);
			}
		}
		else
		{
			category.setCategoryName(categoryName);
			category.setCategoryDesc(categoryDesc);
			categoryDAO.add(category);
		}
		m.addAttribute("categoryList", categoryDAO.listCategories()); 
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		boolean productsExistWithSameCategory=false;
		for(Product product : productDAO.listProducts())
		{
			if(product.getCategoryId()==categoryId)
			{
				productsExistWithSameCategory=true;
				break;
			}
		}
		if(productsExistWithSameCategory)
			m.addAttribute("deleteError",true);
		else
			categoryDAO.delete(category);
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList); 
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		m.addAttribute("category",category);
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/updateCategory")
	public String updateCategory(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc") String categoryDesc,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.update(category);
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		return "Category";
	}
}