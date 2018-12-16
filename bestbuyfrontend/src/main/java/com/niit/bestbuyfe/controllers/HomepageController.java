package com.niit.bestbuyfe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.niit.bestbuy.dao.ProductDAO;

@Controller
public class HomepageController 
{
	@Autowired
	ProductDAO productDAO;
	
}
