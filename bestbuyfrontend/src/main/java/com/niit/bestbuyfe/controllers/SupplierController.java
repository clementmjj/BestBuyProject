package com.niit.bestbuyfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.bestbuy.dao.SupplierDAO;
import com.niit.bestbuy.model.Supplier;


@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/supplier")
	public String showSupplier(Model m)
	{
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",supplierList);
		m.addAttribute("addSupplier",new Supplier());
		return "Supplier";
	}
	
	@RequestMapping(value="/addSupplier", method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("addSupplier") Supplier supplier, Model m)
	{
		supplierDAO.add(supplier);
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",supplierList);
		m.addAttribute("addSupplier",new Supplier());
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId, Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplierDAO.delete(supplier);
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",supplierList);
		m.addAttribute("addSupplier",new Supplier());
		return "Supplier";
	}
	
	@RequestMapping(value="/editSupplier/{supplierId}")
	public String showUpdateSupplier(@PathVariable("supplierId") int supplierId, Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		m.addAttribute("updateSupplier", supplier);
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/updateSupplier", method=RequestMethod.POST)
	public String updateSupplier(@ModelAttribute("updateSupplier") Supplier supplier, Model m)
	{
		supplierDAO.update(supplier);
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",supplierList);
		m.addAttribute("addSupplier", new Supplier());
		return "Supplier";
	}
}
