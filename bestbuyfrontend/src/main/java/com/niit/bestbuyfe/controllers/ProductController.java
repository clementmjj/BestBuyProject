package com.niit.bestbuyfe.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.niit.bestbuy.dao.CategoryDAO;
import com.niit.bestbuy.dao.ProductDAO;
import com.niit.bestbuy.dao.SupplierDAO;
import com.niit.bestbuy.model.Category;
import com.niit.bestbuy.model.Product;
import com.niit.bestbuy.model.Supplier;
import com.niit.bestbuyfe.sort.SortCategoriesByName;
import com.niit.bestbuyfe.sort.SortSuppliersByName;


@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
		
	@RequestMapping(value="/product")
	public String showProduct(Model m)
	{
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		m.addAttribute("addProduct",new Product());
		return "Product";
	}
	
	@RequestMapping(value="/productDisplay/{productId}")
	public String showFullProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product",product);
		return "ProductDisplay";
	}
	
	@ModelAttribute("productList")
	public List<Product> getProductList()
	{
		return productDAO.listProducts();
	}	
	
	@ModelAttribute("categoryListMap")
	public Map<String,String> getCategoryList()
	{
		List<Category> categoryList=categoryDAO.listCategories();
		Collections.sort(categoryList, new SortCategoriesByName());
		LinkedHashMap<String,String> categoryListMap=new LinkedHashMap<String,String>();
		for(Category c: categoryList)
		{
			categoryListMap.put(Integer.toString(c.getCategoryId()), c.getCategoryName());
		}

		return categoryListMap;
	}
	
	@ModelAttribute("supplierListMap")
	public Map<String,String> getSupplierList()
	{
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		Collections.sort(supplierList, new SortSuppliersByName());
		LinkedHashMap<String,String> supplierListMap=new LinkedHashMap<String,String>();
		for(Supplier s: supplierList)
		{
			supplierListMap.put(Integer.toString(s.getSupplierId()), s.getSupplierName());
		}

		return supplierListMap;
	}
	
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("addProduct") Product product, Model m, HttpServletRequest request)
	{
		productDAO.add(product);
		MultipartFile file=product.getImage();
		try 
		{
			if(!file.isEmpty())
			{
				byte[] bytes=file.getBytes();
				Path path=Paths.get("D:\\S191113400168 project\\bestbuyfrontend\\src\\main\\webapp\\resources\\images\\"+product.getProductId()+".jpg");
				Files.write(path, bytes);
				System.out.println("file uploaded");
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		m.addAttribute("addProduct",new Product());
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId, Model m)
	{
		Product product=productDAO.getProduct(productId);
		productDAO.delete(product);
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		m.addAttribute("addProduct",new Product());
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String showUpdateProduct(@PathVariable("productId") int productId, Model m)
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute("updateProduct", product);
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/updateProduct", method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("updateProduct") Product product, Model m)
	{
		productDAO.update(product);
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		m.addAttribute("addProduct", new Product());
		return "Product";
	}
}
