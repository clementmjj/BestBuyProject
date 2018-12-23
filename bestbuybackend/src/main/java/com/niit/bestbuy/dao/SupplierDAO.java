package com.niit.bestbuy.dao;

import java.util.List;

import com.niit.bestbuy.model.Supplier;

public interface SupplierDAO 
{
	public boolean add(Supplier supplier);
	public boolean delete(Supplier supplier);
	public boolean update(Supplier supplier);
	public List<Supplier> listSuppliers();
	public Supplier getSupplier(int supplierId);
}
