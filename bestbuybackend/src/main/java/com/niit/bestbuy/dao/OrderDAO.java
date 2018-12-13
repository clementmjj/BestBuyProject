package com.niit.bestbuy.dao;

import com.niit.bestbuy.model.OrderDetail;

public interface OrderDAO 
{
	public boolean createOrder(OrderDetail order);
	public boolean updateCartItemStatus(String username);
}
