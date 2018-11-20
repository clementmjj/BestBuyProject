package com.niit.bestbuy.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bestbuy.dao.ProductDAO;
import com.niit.bestbuy.model.Product;

public class ProductDAOTestCase 
{
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setCategoryId(1);
		product.setProductName("Round Clay flowerpot");
		product.setProductDesc("Black clay flower pot shape: round");
		product.setPrice(200);
		product.setStock(10);
		product.setSupplierId(1);
		assertTrue("Problem adding product",productDAO.add(product));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(5);
		assertTrue("Problem deleting product",productDAO.delete(product));
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(1);
		product.setPrice(300);
		assertTrue("Problem updating product",productDAO.update(product));
	}
	
	@Ignore
	@Test
	public void listProductsTest()
	{
		List<Product> productList=productDAO.listProducts();
		assertTrue("Problem listing products.", productList.size()>0);
		
		for(Product p : productList)
		{
			System.out.print("Product Id: "+p.getProductId()+"\t");
			System.out.print("Product name: "+p.getProductName()+"\t");
			System.out.print("Product Desc: "+p.getProductDesc()+"\n\n");
		}
	}
}
