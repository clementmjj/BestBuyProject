package com.niit.bestbuy.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bestbuy.dao.CartItemDAO;
import com.niit.bestbuy.model.CartItem;

public class CartItemDAOTestCase 
{
	static CartItemDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO=(CartItemDAO)context.getBean("cartDAO");
	}
	@Ignore
	@Test
	public void addCartItemTest()
	{
		CartItem cart=new CartItem();
		cart.setProductId(99);
		cart.setProductName("curtain");
		cart.setPrice(300);
		cart.setUsername("sunil");
		cart.setStatus("N");
		assertTrue("Problem adding cart item",cartDAO.addToCart(cart));
	}
	
	@Ignore
	@Test
	public void deleteCartItemTest()
	{
		CartItem cart=cartDAO.getCartItem(197);
		assertTrue("Problem deleting cart item",cartDAO.deleteFromCart(cart));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		CartItem cart=cartDAO.getCartItem(199);
		cart.setPrice(666);
		assertTrue("Problem updating cart",cartDAO.updateCartItem(cart));
	}
	
	@Ignore
	@Test
	public void listCartByUnameTest()
	{
		List<CartItem> cartList=cartDAO.listCartItemsByUsername("clement");
		assertTrue("Problem in listing cart items",cartList.size()>0);
		
		for(CartItem c : cartList)
		{
			System.out.print("Cart Id: "+c.getCartItemId()+"\t");
			System.out.print("Cart price: "+c.getPrice()+"\t");
			System.out.print("Cart productId: "+c.getProductId()+"\n\n");
		}
	}
	
	@Ignore
	@Test
	public void listAllCartItemsTest()
	{
		List<CartItem> cartList=cartDAO.listAllCartItems();
		assertTrue("Problem in listing cart items",cartList.size()>0);
		
		for(CartItem c : cartList)
		{
			System.out.print("Cart Id: "+c.getCartItemId()+"\t");
			System.out.print("Cart price: "+c.getPrice()+"\t");
			System.out.print("Cart productId: "+c.getProductId()+"\n\n");
		}
	}
	
	@Ignore
	@Test
	public void getCartItemTest()
	{
		CartItem cart=cartDAO.getCartItem(201);
		assertEquals("curtain",cart.getProductName());
	}
}
