package com.niit.bestbuy.dao;

import java.util.List;

import com.niit.bestbuy.model.CartItem;

public interface CartItemDAO 
{
	public boolean addToCart(CartItem cartItem);
	public boolean deleteFromCart(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public CartItem getCartItem(int cartId);
	public List<CartItem> listCartItemsByUsername(String username);
	public List<CartItem> listAllCartItems();
}
