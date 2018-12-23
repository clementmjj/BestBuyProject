package com.niit.bestbuy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
public class Supplier 
{
	@Id
	@GeneratedValue
	private int supplierId;	
	@NotBlank(message="Must not be blank")
	@Size(min=1, max=30, message="Supplier name must be between 1 to 30 characters")
	private String supplierName;	
	@NotBlank(message="Must not be blank")
	@Size(min=1, max=250, message="Supplier address must be between 1 to 250 characters")
	private String supplierAddress;
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
}