package com.niit.bestbuy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bestbuy.model.CartItem;

@Repository("cartDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addToCart(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteFromCart(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public CartItem getCartItem(int cartId) 
	{
		Session session =sessionFactory.openSession();
		CartItem cartItem=session.get(CartItem.class, cartId);
		session.close();
		return cartItem;
	}

	@Override
	public List<CartItem> listCartItemsByUsername(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where username=:uname and status='N'");
		query.setParameter("uname", username);
		List<CartItem> cartItemsList=query.list();
		session.close();
		return cartItemsList;
	}

	@Override
	public List<CartItem> listAllCartItems() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem");
		List<CartItem> cartItemsList=query.list();
		session.close();
		return cartItemsList;
	}

}
