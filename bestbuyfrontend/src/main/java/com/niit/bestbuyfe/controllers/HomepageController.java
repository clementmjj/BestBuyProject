package com.niit.bestbuyfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.bestbuy.dao.ProductDAO;
import com.niit.bestbuy.model.Product;

@Controller
public class HomepageController 
{
	@Autowired
	ProductDAO productDAO;
	
}
