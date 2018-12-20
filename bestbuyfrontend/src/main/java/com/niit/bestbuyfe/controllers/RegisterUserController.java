package com.niit.bestbuyfe.controllers;


import javax.validation.Valid;


//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String addUser(@ModelAttribute("addUser")@Valid User user, BindingResult result, Model m)
	{
		if(result.hasErrors())
		{
			return "Register";
		}
		else
		{
			user.setEnabled(true);
			user.setRole("ROLE_USER");
			try 
			{
				userDAO.registerUser(user);
			} 
			catch (DataIntegrityViolationException e) 
			{
				System.out.println("in catch");
				result.addError(new FieldError("usernameField", "username", "Username exists"));
				return "Register";
			}
		}
		
		return "Login";
	}
}
