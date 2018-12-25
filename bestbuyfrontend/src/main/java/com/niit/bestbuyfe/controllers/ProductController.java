package com.niit.bestbuyfe.controllers;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.bestbuy.dao.CartItemDAO;
import com.niit.bestbuy.dao.CategoryDAO;
import com.niit.bestbuy.dao.ProductDAO;
import com.niit.bestbuy.dao.SupplierDAO;
import com.niit.bestbuy.model.CartItem;
import com.niit.bestbuy.model.Category;
import com.niit.bestbuy.model.Product;
import com.niit.bestbuy.model.Supplier;


@Controller
public class ProductController 
{
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CartItemDAO cartDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO;
		
	@RequestMapping(value="/product")
	public String showProduct(Model m)
	{
		m.addAttribute("productList",productDAO.listProducts());
		m.addAttribute("addProduct",new Product());
		return "Product";
	}
	
	@RequestMapping(value="/productDisplay/{productId}")
	public String showFullProduct(@PathVariable("productId")int productId,Model m, HttpServletRequest request) throws UnsupportedEncodingException
	{
		Product product=productDAO.getProduct(productId);		
		//set product image extension
		try {
			File productImage=getProductImage(productId, request);
			product.setImageExt(productImage.getName().substring(productImage.getName().lastIndexOf(".")));
		} catch (Exception e) {
			System.out.println("Product "+product.getProductId()+": No image found");
		}
		m.addAttribute("product",product);
		//show related products
		List<Product> relatedProductsList=new LinkedList<Product>();
		int count=0;
		for(Product p : productDAO.listProducts())
		{
			if(count>4)
				break;
			if(p.getProductId()==product.getProductId())
				continue;
			if(p.getCategoryId()==product.getCategoryId())
				{
					//set product image extension
					try {
						File productImage=getProductImage(p.getProductId(), request);
						p.setImageExt(productImage.getName().substring(productImage.getName().lastIndexOf(".")));
					} 
					catch (Exception e) {
						System.out.println("Related Product "+product.getProductId()+": No image found");
					}
					relatedProductsList.add(p);
					count++;
				}
		}
		m.addAttribute("relatedProductsList", relatedProductsList);
		return "ProductDisplay";
	}
	
	
	@ModelAttribute("categoryListMap")
	public Map<String,String> getCategoryList()
	{
		List<Category> categoryList=categoryDAO.listCategories();
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
	public String addProduct(@ModelAttribute("addProduct") @Valid Product product, BindingResult result, Model m, 
			HttpServletRequest request)
	{
		MultipartFile file=product.getImage();
		String fileExt=null;
		if(file.isEmpty())
			result.addError(new FieldError("imageInput","image", "Please select an image"));
		else
		{
			fileExt=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			if(!fileExt.equalsIgnoreCase(".jpg") && !fileExt.equalsIgnoreCase(".jpeg") && !fileExt.equalsIgnoreCase(".png") &&
					!fileExt.equalsIgnoreCase(".bmp"))
				result.addError(new FieldError("imageInput","image", "Image must be either jpg, jpeg, png or bmp"));
			if(file.getSize()>1000000)
				result.addError(new FieldError("imageInput","image", "Image size limit is 1MB"));
		}
		if(result.hasErrors())
		{
			m.addAttribute("errors",true);
			return "Product";
		}
		else
		{	
			productDAO.add(product);
			//saving image
			try
			{
				byte[] bytes=file.getBytes();
				Path path=Paths.get(getImagesDir(request)+product.getProductId()+fileExt);
				Files.write(path, bytes);
				System.out.println("image uploaded");
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			m.addAttribute("productList",productDAO.listProducts());
			m.addAttribute("addProduct",new Product());
		}
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId, Model m, HttpServletRequest request) throws UnsupportedEncodingException
	{
		Product product=productDAO.getProduct(productId);
		productDAO.delete(product);
		
		//delete product from all carts
		for(CartItem ci : cartDAO.listAllCartItems())
		{
			if(ci.getProductId()==productId)
				cartDAO.deleteFromCart(ci);
		}
		
		//delete image
		File productImage=getProductImage(productId, request);
		try {
			productImage.delete();
		} catch (NullPointerException e) {
			System.out.println("Product "+productId+": Could not delete image as image was not found.");
		}
			catch (Exception e) {
				e.printStackTrace();
		}
		
		m.addAttribute("productList",productDAO.listProducts());
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
	public String updateProduct(@ModelAttribute("updateProduct") @Valid Product product, BindingResult result, Model m)
	{
		if(result.hasErrors())
			return "UpdateProduct";
		else
		{
			productDAO.update(product);
			List<Product> productList=productDAO.listProducts();
			m.addAttribute("productList",productList);
			m.addAttribute("addProduct", new Product());
			return "Product";
		}
		
	}
	
	@RequestMapping(value="/home")
	public String showAllProducts(Model m, HttpServletRequest request) throws UnsupportedEncodingException
	{
		List<Product> productsWithAvailableStock=new LinkedList<Product>();
		for(Product product : productDAO.listProducts())
		{
			if(product.getStock()>0)
				productsWithAvailableStock.add(product);
		}
		
		//set products' image extension
		for(Product product : productsWithAvailableStock)
		{
			try {
				File productImage=getProductImage(product.getProductId(), request);
				product.setImageExt(productImage.getName().substring(productImage.getName().lastIndexOf(".")));
			} catch (Exception e) {
				System.out.println("Product "+product.getProductId()+": No image found");
			}
		}
		m.addAttribute("productList", productsWithAvailableStock);
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
