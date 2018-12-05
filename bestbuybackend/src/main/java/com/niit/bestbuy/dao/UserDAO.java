package com.niit.bestbuy.dao;

import java.util.List;

import com.niit.bestbuy.model.User;

public interface UserDAO 
{
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String userName);
	public List<User> listUsers();
}
