package com.niit.bestbuy.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
	}
}
