package com.niit.bestbuy.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bestbuy.model.OrderDetail;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean createOrder(OrderDetail order) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(order);
			return true;
		} 
		catch (HibernateException e) 
		{
			return false;
		}
	}

	@Override
	public boolean updateCartItemStatus(String username) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("update cartitem set status='P' where username=:uname");
			query.setParameter("uname", username);
			int rowsEffected=query.executeUpdate();
			session.close();
			if(rowsEffected>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
