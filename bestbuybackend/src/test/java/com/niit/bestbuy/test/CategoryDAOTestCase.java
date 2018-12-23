package com.niit.bestbuy.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bestbuy.dao.CategoryDAO;
import com.niit.bestbuy.model.Category;

public class CategoryDAOTestCase 
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		context.close();
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Skipping Rope");
		category.setCategoryDesc("Skipping Ropes");
		assertTrue("Problem adding category",categoryDAO.add(category));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem deleting category DAO",categoryDAO.delete(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		category.setCategoryDesc("Plain center flowerpots");
		assertTrue("Problem updating category",categoryDAO.update(category));
	}
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> categoryList=categoryDAO.listCategories();
		assertTrue("Problem in listing categories",categoryList.size()>0);		
		for(Category c : categoryList)
		{
			System.out.print("Category Id: "+c.getCategoryId()+"\t");
			System.out.print("Category name: "+c.getCategoryName()+"\t");
			System.out.print("Category Desc: "+c.getCategoryDesc()+"\n\n");
		}
	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		assertEquals("Mobile Phones",category.getCategoryName());
	}
}
