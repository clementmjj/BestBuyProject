package com.niit.bestbuyfe.controllers;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.bestbuy.dao.CartItemDAO;
import com.niit.bestbuy.dao.ProductDAO;
import com.niit.bestbuy.model.CartItem;
import com.niit.bestbuy.model.Product;

@Controller
public class CartItemController 
{
	@Autowired
	private CartItemDAO cartDAO;
	@Autowired
	private ProductDAO productDAO;
	
	public void showCartItems(Model m, HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException
	{
		List<CartItem> cartItemList=cartDAO.listCartItemsByUsername(session.getAttribute("username").toString());
		//get cart items images
		for(CartItem cartItem : cartItemList)
		{
			File cartItemImage=new ProductController().getProductImage(cartItem.getProductId(), request);
			try {
				cartItem.setImageExt(cartItemImage.getName().substring(cartItemImage.getName().lastIndexOf(".")));
			} catch (Exception e) {
				System.out.println("Cart Item "+cartItem.getProductId()+": No image found");
			}
		}
		//get productName, price and stock of each item so that their respective fields can be filled
		for(CartItem cartItem : cartItemList)
		{
			Product product = productDAO.getProduct(cartItem.getProductId());
			cartItem.setProductName(product.getProductName());
			cartItem.setPrice(product.getPrice());
			cartItem.setStock(product.getStock());
		}
		m.addAttribute("cartItems", cartItemList);
	}
	
	@RequestMapping(value="/viewcart")
	public String showCart(Model m, HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException
	{
		showCartItems(m, request, session);
		return "Cart";
	}
	
	@RequestMapping(value="/addtocart/{productId}")
	public String addToCart(@PathVariable("productId") int productId, Model m, HttpServletRequest request,
			HttpSession session) throws UnsupportedEncodingException
	{
		List<CartItem> cartItemList=cartDAO.listCartItemsByUsername(session.getAttribute("username").toString());
		boolean isItemInCart=false;
		for(CartItem ci : cartItemList)
		{
			if(ci.getProductId()==productId)
			{
				isItemInCart=true;
				ci.setQuantity(ci.getQuantity()+1);
				cartDAO.updateCartItem(ci);
				break;
			}
		}
		if(isItemInCart==false)
		{
			Product product=productDAO.getProduct(productId);
			CartItem cartItem=new CartItem();
			cartItem.setProductId(productId);
			cartItem.setQuantity(1);
			cartItem.setProductName(product.getProductName());
			cartItem.setPrice(product.getPrice());
			cartItem.setStatus("N");
			cartItem.setUsername(session.getAttribute("username").toString());
			cartDAO.addToCart(cartItem);
		}
		showCartItems(m, request,session);
		return "Cart";
	}
	
	@RequestMapping(value="/deletefromcart/{cartItemId}")
	public String deleteFromCart(@PathVariable("cartItemId") int cartItemId, Model m, HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException
	{
		CartItem cartItem=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteFromCart(cartItem);
		showCartItems(m, request,session);
		return "Cart";
	}
	
	@RequestMapping(value="/updateCartItemPrice/{cartItemId}")
	public String updateCartItemPrice(@RequestParam("quantity") int quantity, @PathVariable("cartItemId") int cartItemId, Model m, HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException
	{
		CartItem cartItem=cartDAO.getCartItem(cartItemId);
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);		
		showCartItems(m, request,session);
		return "Cart";
	}
}
