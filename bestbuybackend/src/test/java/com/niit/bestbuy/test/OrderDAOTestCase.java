package com.niit.bestbuy.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bestbuy.dao.CartItemDAO;
import com.niit.bestbuy.dao.OrderDAO;
import com.niit.bestbuy.model.CartItem;
import com.niit.bestbuy.model.OrderDetail;

public class OrderDAOTestCase 
{
	static OrderDAO orderDAO;
	CartItemDAO cartItemDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		orderDAO=(OrderDAO)context.getBean("orderDAO");
	}
	
	@Test
	public void createOrderTest()
	{
		OrderDetail order=new OrderDetail();
		order.setOrderDate(new Date());
		order.setPaymentMode("CC");
		order.setUsername("Rohan");
		order.setTotalAmount(5000);
		assertTrue("Problem creating order",orderDAO.createOrder(order));
	}
	
	@Ignore
	@Test
	public void updateCartItemStatusTest()
	{
		assertTrue("Problem in updating Cart item status",orderDAO.updateCartItemStatus("Rohan"));
		
	}
}
