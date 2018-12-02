package com.niit.bestbuyfe.sort;

import java.util.Comparator;

import com.niit.bestbuy.model.Supplier;

public class SortSuppliersByName implements Comparator<Supplier>
{

	@Override
	public int compare(Supplier o1, Supplier o2) 
	{
		return o1.getSupplierName().compareToIgnoreCase(o2.getSupplierName());
	}
	
}