package com.niit.bestbuyfe.controllers;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.bestbuy.model.User;

@Controller
public class UserController 
{
	@RequestMapping(value="/login")
	public String showLogin(Model m)
	{
		m.addAttribute("login", new User());
		return "Login";
	}
	
	@RequestMapping(value="/perform_login")
	public String loginSuccess(HttpSession session, Model m, Principal principal)
	{
		System.out.println("in login success method");
		String page="";
		boolean loggedIn=false;

		SecurityContext sContext=SecurityContextHolder.getContext();//this object will contain the logged-in user details like username and role
		Authentication authentication =sContext.getAuthentication(); //
		System.out.println(authentication.getName());
		
		//getting the role of user
		String username=authentication.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role : roles)
		{
			session.setAttribute("role", role.getAuthority());
			System.out.println("role: "+ role);
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
				page="Home";
			}
		}
		return page;
	}
}
