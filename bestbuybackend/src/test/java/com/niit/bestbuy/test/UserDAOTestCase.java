package com.niit.bestbuy.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bestbuy.dao.UserDAO;
import com.niit.bestbuy.model.User;

public class UserDAOTestCase 
{
	static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void registerUserTest()
	{
		User user=new User();
		user.setUserName("ashwin");
		user.setUserFullName("Clement S");
		user.setPassword("abc123");
		user.setEmail("clement@gmail.com");
		user.setEnabled(true);
		user.setMobileNo("8678421588");
		user.setRole("ROLE_USER");
		user.setUserAddress("Bangalore");
		assertTrue("Problem registering user",userDAO.registerUser(user));
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser("clement");
		user.setUserAddress("Kerala");
		assertTrue("Problem updating user",userDAO.updateUser(user));
	}
}
