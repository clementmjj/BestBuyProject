package com.niit.bestbuy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product 
{
	@Id
	@GeneratedValue
	private int productId;	
	@Positive (message="Please select a supplier")
	private int supplierId;	
	@Positive (message="Please select a category")
	private int categoryId;
	@PositiveOrZero(message="Please enter a positive number")
	private int stock;
	@Min(value=1, message="Price must be atleast Rs.1")
	private double price;
	@NotBlank(message="Must not be blank")
	@Size(min=1, max=100, message="Product name must be between 1 to 100 characters")
	private String productName;
	@NotBlank(message="Must not be blank")
	@Size(min=1, max=255, message="Product description must be between 1 to 255 characters")
	private String productDesc;	
	@Transient
	private MultipartFile image;	
	@Transient
	private String imageExt;	
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getImageExt() {
		return imageExt;
	}
	public void setImageExt(String imageExt) {
		this.imageExt = imageExt;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
}