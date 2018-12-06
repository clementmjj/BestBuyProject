package com.niit.bestbuy.dao;

import java.util.List;

import com.niit.bestbuy.model.Cart;

public interface CartDAO 
{
	public boolean addToCart(Cart cart);
	public boolean deleteFromCart(Cart cart);
	public boolean updateCateItem(Cart cart);
	public Cart getCartItem(int cartId);
	public List<Cart> listCartItems(String username);
}
