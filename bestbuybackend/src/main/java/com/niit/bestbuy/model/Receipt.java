package com.niit.bestbuy.model;

import java.io.Serializable;
import java.util.List;

public class Receipt implements Serializable
{
	private static final long serialVersionUID = 3217127085643176472L;
	private int orderId;
	private List<CartItem> cartItemsList;
	
	public Receipt(int orderId, List<CartItem> cartItemsList)
	{
		this.orderId=orderId;
		this.cartItemsList=cartItemsList;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<CartItem> getCartItemsList() {
		return cartItemsList;
	}
	public void setCartItemsList(List<CartItem> cartItemsList) {
		this.cartItemsList = cartItemsList;
	}
	
	
}
