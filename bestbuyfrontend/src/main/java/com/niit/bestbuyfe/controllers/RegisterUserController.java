package com.niit.bestbuyfe.controllers;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.bestbuy.dao.UserDAO;
import com.niit.bestbuy.model.User;

@Controller
public class RegisterUserController 
{
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/register")
	public String showRegister(Model m)
	{
		m.addAttribute("addUser", new User());
		return "Register";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("addUser")/*@Valid*/ User user, @RequestParam("confirmPassword")String confirmPassword, 
			BindingResult result, Model m)
	{
		if(result.hasErrors())
		{
			m.addAttribute("errors", true);	
		}
		else
		{
			if(confirmPassword.equals(user.getPassword()))
			{
				user.setEnabled(true);
				user.setRole("ROLE_USER");
				userDAO.registerUser(user);
			}
			else
			{
				
			}
		}
		
		return "Login";
	}
}
