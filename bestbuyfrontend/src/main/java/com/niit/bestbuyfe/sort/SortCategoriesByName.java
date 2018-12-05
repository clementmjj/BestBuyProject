package com.niit.bestbuyfe.sort;

import java.util.Comparator;

import com.niit.bestbuy.model.Category;

public class SortCategoriesByName implements Comparator<Category>
{

	@Override
	public int compare(Category o1, Category o2) 
	{
		return o1.getCategoryName().compareToIgnoreCase(o2.getCategoryName());
	}
	
}