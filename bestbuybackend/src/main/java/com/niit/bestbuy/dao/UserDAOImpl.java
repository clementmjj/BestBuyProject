package com.niit.bestbuy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.bestbuy.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public User getUser(String userName) 
	{
		Session session=sessionFactory.openSession();
		User user=session.get(User.class, userName);
		session.close();
		return user;
	}

	@Override
	public List<User> listUsers() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> userList=query.list();
		session.close();
		return userList;
	}	
}