package com.niit.bestbuy.dao;

import com.niit.bestbuy.model.User;

public interface UserDAO 
{
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String userId);
}
