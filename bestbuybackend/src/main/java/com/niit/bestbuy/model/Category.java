package com.niit.bestbuy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
public class Category 
{
	@Id
	@GeneratedValue
	private int categoryId;
	
	@NotBlank(message="Must not be blank")
	@Size(min=5, max=15, message="Category name must be between 5 to 15 characters")
	private String categoryName;
	
	@NotBlank(message="Must not be blank")
	@Size(min=5, max=200, message="Category description must be between 5 to 200 characters")
	private String categoryDesc;
	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	
}
