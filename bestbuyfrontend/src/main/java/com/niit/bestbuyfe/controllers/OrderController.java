package com.niit.bestbuyfe.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.bestbuy.dao.CartItemDAO;
import com.niit.bestbuy.dao.OrderDAO;
import com.niit.bestbuy.dao.ProductDAO;
import com.niit.bestbuy.model.CartItem;
import com.niit.bestbuy.model.OrderDetail;
import com.niit.bestbuy.model.Product;

@Controller
public class OrderController 
{
	@Autowired
	CartItemDAO cartDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping(value="/showOrder/{username}")
	public String showOrder(@PathVariable("username") String username,@RequestParam Map<String, String> params, Model m)
	{
		//updating quantity in db
		List<CartItem> cartItemList=cartDAO.listCartItems(username);
		for(CartItem ci : cartItemList)
		{
			for(Map.Entry<String, String> entry : params.entrySet())
			{	
				if(Integer.toString(ci.getProductId()).equals(entry.getKey().substring(0,entry.getKey().indexOf("_"))))
				{
					ci.setQuantity(Integer.parseInt(entry.getValue()));
					cartDAO.updateCartItem(ci);
					break;
				}
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
		m.addAttribute("orderItems",cartItemList);
		m.addAttribute("orderDetail", new OrderDetail());
		return "Order";
	}
	
	@RequestMapping(value="/confirmOrder/{username}")
	public String createOrder(Model m, @ModelAttribute("orderDetail") OrderDetail order)
	{
		List<CartItem> cartItemList=cartDAO.listCartItems(order.getUsername());
		double grandTotal=0;
		for(CartItem ci : cartItemList)
		{
			Product product=productDAO.getProduct(ci.getProductId());
			//setting the price and product name so that their respective fields can be populated in reciept
			ci.setProductName(product.getProductName());
			ci.setPrice(product.getPrice());
			
			//getting the grand total amt of order
			double totalPrice=ci.getPrice()*ci.getQuantity();
			grandTotal+=totalPrice;
		}
		order.setOrderDate(new Date());
		order.setTotalAmount(grandTotal);
		
		orderDAO.createOrder(order);
		
		m.addAttribute("itemList", cartItemList);
		m.addAttribute("order", order);
		return "Receipt";
	}
}
