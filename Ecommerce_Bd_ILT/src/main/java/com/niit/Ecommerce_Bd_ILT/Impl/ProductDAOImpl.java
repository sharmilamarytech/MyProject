package com.niit.Ecommerce_Bd_ILT.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Ecommerce_Bd_ILT.DAO.ProductDAO;
import com.niit.Ecommerce_Bd_ILT.Model.ProductModel;

@Repository
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}

	public void addproduct(ProductModel product)
	{
		try
		{
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			s.save(product);
			s.getTransaction().commit();
			s.close();
		}
		catch(Exception r)
		{
			System.out.println(r);
			r.printStackTrace();
		}
		
	}

	public ProductModel findById(int id)
	{
		
		return (ProductModel)sessionFactory.openSession().get(ProductModel.class, id);
		
	}

	public List<ProductModel> getAll() 
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		Query query=s.createQuery("from ProductModel");
		List<ProductModel>list=query.list();
		System.out.println(list);
		s.getTransaction();
		return list;
	}
	public List<ProductModel> getFilterProducts(int categoryid)
	{
		Session s=sessionFactory.openSession();
		List<ProductModel> results=s.createQuery("from ProductModel where categoryid="+categoryid).list();
		s.close();
		return results;
		
	}
	
	public void update(ProductModel product) {

		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(product);
		s.getTransaction().commit();
		s.close();
		
	}
	}
