package com.niit.bestbuyfe.controllers;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String showFullProduct(@PathVariable("productId")int productId,Model m, HttpServletRequest request) throws UnsupportedEncodingException
	{
		Product product=productDAO.getProduct(productId);		
		
		//set product image extension
		File productImage=getProductImage(productId, request);
		try {
			product.setImageExt(productImage.getName().substring(productImage.getName().lastIndexOf(".")));
		} catch (Exception e) {
			System.out.println("Product "+product.getProductId()+": No image found");
		}
		
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
	
	public String getImagesDir(HttpServletRequest request) throws UnsupportedEncodingException
	{
		String workingDir=null, projectName=null;
		workingDir=URLDecoder.decode(this.getClass().getClassLoader().getResource("").getPath(), "UTF-8");
		workingDir=workingDir.substring(1,workingDir.indexOf(".metadata")).replace('/', '\\');
		projectName=request.getContextPath().substring(1)+"\\";
		return workingDir+projectName+"src\\main\\webapp\\resources\\images\\ProductImages\\";
	}
	
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("addProduct") Product product, Model m, HttpServletRequest request)
	{
		productDAO.add(product);
		MultipartFile file=product.getImage();
		if(!file.isEmpty())
		{
			String fileExt=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			try
			{
				byte[] bytes=file.getBytes();
				Path path=Paths.get(getImagesDir(request)+product.getProductId()+fileExt);
				Files.write(path, bytes);
				System.out.println("file uploaded");
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		m.addAttribute("addProduct",new Product());
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId, Model m, HttpServletRequest request) throws UnsupportedEncodingException
	{
		Product product=productDAO.getProduct(productId);
		productDAO.delete(product);
		
		//delete image
		File productImage=getProductImage(productId, request);
		try {
			productImage.delete();
		} catch (NullPointerException e) {
			System.out.println("Product "+productId+": Could not delete image as image was not found.");
		}
			catch (Exception e) {
				System.out.println("Product "+productId+": Could not delete image.");
		}
		
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
	
	@RequestMapping(value="/allproducts")
	public String showAllProducts(Model m, HttpServletRequest request) throws UnsupportedEncodingException
	{
		List<Product> productList=productDAO.listProducts();
		
		//set products' image extension
		for(Product product : productList)
		{
			File productImage=getProductImage(product.getProductId(), request);
			try {
				product.setImageExt(productImage.getName().substring(productImage.getName().lastIndexOf(".")));
			} catch (Exception e) {
				System.out.println("Product "+product.getProductId()+": No image found");
			}
		}
		m.addAttribute("productList", productList);
		return "AllProducts";
	}
	
	public File getProductImage(int productId, HttpServletRequest request) throws UnsupportedEncodingException
	{
		File productImage = null;
		File imgDir=new File(getImagesDir(request));
		for(File f : imgDir.listFiles())
		{
			if(f.isFile())
			{
				String fileName=f.getName().substring(0, f.getName().lastIndexOf("."));
				if(fileName.equals(Integer.toString(productId)))
				{
					productImage = f;
					break;
				}
			}
		}
		return productImage;
	}
}
