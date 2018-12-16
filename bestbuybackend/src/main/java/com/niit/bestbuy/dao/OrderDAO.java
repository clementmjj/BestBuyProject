package com.niit.bestbuy.dao;

import java.util.List;

import com.niit.bestbuy.model.OrderDetail;

public interface OrderDAO 
{
	public boolean createOrder(OrderDetail order);
	public boolean updateCartItemStatus(String username);
	public OrderDetail getOrder(int orderId);
	public List<OrderDetail> listOrders(String username);
}
