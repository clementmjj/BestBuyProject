package com.niit.bestbuy.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bestbuy.dao.CartDAO;
import com.niit.bestbuy.model.Cart;
import com.niit.bestbuy.model.Category;

public class CartDAOTestCase 
{
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Test
	public void addCartItemTest()
	{
		Cart cart=new Cart();
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
		Cart cart=cartDAO.getCartItem(197);
		assertTrue("Problem deleting cart item",cartDAO.deleteFromCart(cart));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Cart cart=cartDAO.getCartItem(199);
		cart.setPrice(666);
		assertTrue("Problem updating cart",cartDAO.updateCateItem(cart));
	}
	
	@Ignore
	@Test
	public void listCartTest()
	{
		List<Cart> cartList=cartDAO.listCartItems("sunil");
		assertTrue("Problem in listing cart items",cartList.size()>0);
		
		for(Cart c : cartList)
		{
			System.out.print("Cart Id: "+c.getCartId()+"\t");
			System.out.print("Cart price: "+c.getPrice()+"\t");
			System.out.print("Cart productId: "+c.getProductId()+"\n\n");
		}
	}
	
	@Ignore
	@Test
	public void getCartItemTest()
	{
		Cart cart=cartDAO.getCartItem(201);
		assertEquals("curtain",cart.getProductName());
	}
}
