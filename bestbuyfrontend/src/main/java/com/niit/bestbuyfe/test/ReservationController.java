package com.niit.bestbuyfe.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller  
public class ReservationController 
{
    @RequestMapping("/test")  
	public String bookingForm(Model model)  
	{
	    Reservation res=new Reservation();  
	    model.addAttribute("reservation", res);  
	    return "test";  
	}
    
	@RequestMapping("/submitForm")  
	public String submitForm(@ModelAttribute("reservation") Reservation res)  
	{
	    return "test";  
	}
}  