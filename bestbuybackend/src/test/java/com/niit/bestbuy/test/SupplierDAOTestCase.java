package com.niit.bestbuy.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bestbuy.dao.SupplierDAO;
import com.niit.bestbuy.model.Supplier;

public class SupplierDAOTestCase 
{
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		context.close();
	}
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("ABC Traders");
		supplier.setSupplierAddress("Mumbai");
		assertTrue("Problem adding supplier",supplierDAO.add(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(140);
		assertTrue("Problem deleting supplier",supplierDAO.delete(supplier));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(140);
		supplier.setSupplierAddress("Delhi");
		assertTrue("Problem updating supplier",supplierDAO.update(supplier));
	}
	
	@Ignore
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		assertTrue("Problem listing suppliers.", supplierList.size()>0);		
		for(Supplier s : supplierList)
		{
			System.out.print("Supplier Id: "+s.getSupplierId()+"\t");
			System.out.print("Supplier Name: "+s.getSupplierName()+"\t");
			System.out.print("Supplier Addr: "+s.getSupplierAddress()+"\n\n");
		}
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(7);
		assertEquals("ABC Traders",supplier.getSupplierName());
	}
}
