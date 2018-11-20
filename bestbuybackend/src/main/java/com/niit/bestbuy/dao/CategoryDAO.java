package com.niit.bestbuy.dao;

import java.util.List;

import com.niit.bestbuy.model.Category;

public interface CategoryDAO 
{
	public boolean add(Category category);
	public boolean delete(Category category);
	public boolean update(Category category);
	public List<Category> listCategories();
	public Category getCategory(int categoryId);
}
