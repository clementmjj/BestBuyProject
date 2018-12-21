package com.niit.bestbuyfe.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.niit.bestbuy.dao.UserDAO;
import com.niit.bestbuy.model.CartItem;
import com.niit.bestbuy.model.OrderDetail;
import com.niit.bestbuy.model.Product;
import com.niit.bestbuy.model.Receipt;

@Controller
public class OrderController
{
	@Autowired
	CartItemDAO cartDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/showOrder/{username}")
	public String showOrder(@PathVariable("username") String username,@RequestParam Map<String, String> params, Model m)
	{
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, 1);
		String pattern = "yyyy-MM";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		m.addAttribute("ExpMin",simpleDateFormat.format(calendar.getTime()));
		
		//updating quantity in db
		List<CartItem> cartItemList=cartDAO.listCartItemsByUsername(username);
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
	
	@RequestMapping(value="/confirmOrder")
	public String createOrder(Model m, @ModelAttribute("orderDetail") OrderDetail order,HttpSession session,
			@RequestParam("CreditCardNo") String creditCardNo, @RequestParam("CreditCardExp") String creditCardExp, 
			@RequestParam("CreditCardCVV") String creditCardCVV, @RequestParam("DebitCardNo") String debitCardNo, 
			@RequestParam("DebitCardExp") String debitCardExp, @RequestParam("DebitCardCVV") String debitCardCVV) throws IOException
	{
		List<String> errorsList=new LinkedList<String>();
		if(order.getPaymentMode().equals("Credit Card"))
		{
			//credit card no
			if(creditCardNo.trim().equals(""))
				errorsList.add("Credit card number must not be blank");
			else
			{
				if(creditCardNo.length()==16)
				{
					for(char c : creditCardNo.toCharArray())
					{
						try {
							Character.getNumericValue(c);
						}
						catch(Exception e) {
							errorsList.add("Please enter a valid credit card number");
						}
					}
				}
				else
					errorsList.add("Credit card number must be 16 digits");
			}
			
			//Exp date
			if(creditCardExp.isEmpty())
				errorsList.add("Please select the expiry date of the card");
			
			//CVV
			try {
				Integer.parseInt(creditCardCVV);
			}
			catch (Exception e)
			{
				errorsList.add("Please enter a valid CVV number");
			}
		}
		else if(order.getPaymentMode().equals("Debit Card"))
		{
			//debit card no
			if(debitCardNo.trim().equals(""))
				errorsList.add("Debit card number must not be blank");
			else
			{
				if(debitCardNo.length()==16)
				{
					for(char c : debitCardNo.toCharArray())
					{
						try {
							Character.getNumericValue(c);
						}
						catch(Exception e) {
							errorsList.add("Please enter a valid debit card number");
						}
					}
				}
				else
					errorsList.add("Debit card number must be 16 digits");
			}
			
			//Exp date
			if(debitCardExp.isEmpty())
				errorsList.add("Please select the expiry date of the card");
			
			//CVV
			try {
				Integer.parseInt(debitCardCVV);
			}
			catch (Exception e)
			{
				errorsList.add("Please enter a valid CVV number");
			}
		}
		else //cash on delivery
		{
			
		}
		if(!errorsList.isEmpty())
		{
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, 1);
			String pattern = "yyyy-MM";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			m.addAttribute("ExpMin",simpleDateFormat.format(calendar.getTime()));
			
			m.addAttribute("errorsList",errorsList);
			return "Order";
		}
		List<CartItem> cartItemList=cartDAO.listCartItemsByUsername(session.getAttribute("username").toString());
		double grandTotal=0;
		for(CartItem ci : cartItemList)
		{
			Product product=productDAO.getProduct(ci.getProductId());
			//setting the price and product name so that their respective fields can be populated in receipt
			ci.setProductName(product.getProductName());
			ci.setPrice(product.getPrice());
			
			//getting the grand total amt of order
			double totalPrice=ci.getPrice()*ci.getQuantity();
			grandTotal+=totalPrice;
		}
		order.setUsername(session.getAttribute("username").toString());
		order.setOrderDate(new Date());
		order.setTotalAmount(grandTotal);
		orderDAO.createOrder(order);
		
		//updating file with order details so that receipt can be generated by user at any time
			//getting the file path
		String workingDir=null, projectName=null;
		workingDir=URLDecoder.decode(this.getClass().getClassLoader().getResource("").getPath(), "UTF-8");
		workingDir=workingDir.substring(1,workingDir.indexOf(".metadata")).replace('/', '\\');
		projectName=session.getServletContext().getContextPath().substring(1)+"\\";
		String filePath= workingDir+projectName+"src\\main\\webapp\\resources\\orders.bbo";
			
			//updating the file
		Receipt receipt=new Receipt(order.getOrderId(), cartItemList);
		File file= new File(filePath);
		FileOutputStream fos = new FileOutputStream(file, true);
		if(file.exists() && file.length()>0)
		{
			ObjectOutputStream oos = new ObjectOutputStream(fos) 
			{
				protected void writeStreamHeader() throws IOException 
				{
					reset();
				}
			};
			oos.writeObject(receipt);
			oos.close();
		}
		else
		{
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(receipt);
			oos.close();
		}
		fos.close();
		
		//delete order items from cart
		for(CartItem ci : cartItemList)
		{
			//delete order items from cart
			cartDAO.deleteFromCart(ci);
			
			//update stock
			Product product=productDAO.getProduct(ci.getProductId());
			product.setStock(product.getStock()-ci.getQuantity());
			productDAO.update(product);
		}
		
		m.addAttribute("itemList", cartItemList);
		m.addAttribute("order", order);
		m.addAttribute("user",userDAO.getUser(session.getAttribute("username").toString()));
		return "Receipt";
	}
	
	@RequestMapping(value="/myOrders")
	public String showUserOrders(HttpSession session, Model m)
	{
		List<OrderDetail> ordersList=orderDAO.listOrders(session.getAttribute("username").toString());
		m.addAttribute("ordersList", ordersList);
		return "OrderList";
	}
}
