package com.niit.bestbuyfe.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URLDecoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.bestbuy.dao.OrderDAO;
import com.niit.bestbuy.dao.UserDAO;
import com.niit.bestbuy.model.OrderDetail;
import com.niit.bestbuy.model.Receipt;

@Controller
public class ReceiptController 
{
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/receipt/{orderId}")
	public String showReceipt(@PathVariable("orderId")int orderId, HttpSession session, Model m) throws IOException, ClassNotFoundException
	{	
		OrderDetail order=orderDAO.getOrder(orderId);
		String workingDir=null, projectName=null;
		workingDir=URLDecoder.decode(this.getClass().getClassLoader().getResource("").getPath(), "UTF-8");
		workingDir=workingDir.substring(1,workingDir.indexOf(".metadata")).replace('/', '\\');
		projectName=session.getServletContext().getContextPath().substring(1)+"\\";
		String filePath= workingDir+projectName+"src\\main\\webapp\\resources\\orders.bbo";
		
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		while(true)
		{
			Receipt receipt=(Receipt)ois.readObject();
			if(receipt.getOrderId()==orderId)
			{
				m.addAttribute("order", order);
				m.addAttribute("user", userDAO.getUser(session.getAttribute("username").toString()));
				m.addAttribute("itemList", receipt.getCartItemsList());
				return "Receipt";
			}
		}
	}
}
