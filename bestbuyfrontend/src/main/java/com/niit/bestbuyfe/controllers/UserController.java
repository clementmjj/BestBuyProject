package com.niit.bestbuyfe.controllers;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.bestbuy.dao.ProductDAO;
import com.niit.bestbuy.model.Product;

@Controller
public class UserController 
{
	@Autowired
	ProductDAO productDAO;
	
	public static String getLoggedInUser()
	{
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication =sContext.getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping(value="/login/error")
	public String loginFailure(Model m)
	{
		m.addAttribute("loginError",true);
		return "Login";
	}
	
	@RequestMapping(value="/login")
	public String showLogin()
	{
		return "Login";
	}
	
	@RequestMapping(value="/logout_success")
	public String logoutSuccess(HttpSession session)
	{
		session.invalidate();
		return "Login";
	}
	
	@RequestMapping(value="/login_success")
	public String loginSuccess(HttpSession session, Model m, HttpServletRequest request) throws UnsupportedEncodingException
	{
		String page="";
		boolean loggedIn=false;

		//this object will contain the logged-in user details like username and role
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication =sContext.getAuthentication();
		
		//getting the role of user
		String username=authentication.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role : roles)
		{
			session.setAttribute("role", role.getAuthority());
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				loggedIn=true;
				List<Product> productList=productDAO.listProducts();
				
				//set products' image extension
				for(Product product : productList)
				{
					File productImage=new ProductController().getProductImage(product.getProductId(), request);
					try {
						product.setImageExt(productImage.getName().substring(productImage.getName().lastIndexOf(".")));
					} catch (Exception e) {
						System.out.println("Product "+product.getProductId()+": No image found");
					}
				}
				m.addAttribute("productList", productList);
				page="Home";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
		}
		return page;
	}
}
