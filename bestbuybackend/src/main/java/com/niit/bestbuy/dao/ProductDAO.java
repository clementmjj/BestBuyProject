package com.niit.bestbuy.dao;

import java.util.List;

import com.niit.bestbuy.model.Product;


public interface ProductDAO 
{
	public boolean add(Product product);
	public boolean delete(Product product);
	public boolean update(Product product);
	public List<Product> listProducts();
	public Product getProduct(int productId);
}
