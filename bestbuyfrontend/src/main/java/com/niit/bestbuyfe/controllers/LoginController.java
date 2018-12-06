package com.niit.bestbuyfe.controllers;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.bestbuy.dao.ProductDAO;
import com.niit.bestbuy.dao.UserDAO;
import com.niit.bestbuy.model.Product;
import com.niit.bestbuy.model.User;

@Controller
public class LoginController 
{
	@Autowired
	UserDAO userDAO;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/login")
	public String showLogin(Model m)
	{
		m.addAttribute("login", new User());
		return "Login";
	}
	
	@RequestMapping(value="/loginUser")
	public String loginUser(@ModelAttribute("login") User user, Model m, HttpServletRequest request) throws IOException
	{
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		File imgDir=new File(new ProductController().getImagesDir(request));
		for(Product product : productList)
		{
			for(File f : imgDir.listFiles())
			{
				String fileName=f.getName().substring(0, f.getName().lastIndexOf("."));
				if(fileName.equals(Integer.toString(product.getProductId())))
				{
					String fileExt=f.getName().substring(f.getName().lastIndexOf("."));
					m.addAttribute("image", imgDir.getPath()+"\\"+product.getProductId()+fileExt);
					System.out.println(product.getProductName());
					break;
				}
			}
		}
		return "Homepage";
	}
	
}
