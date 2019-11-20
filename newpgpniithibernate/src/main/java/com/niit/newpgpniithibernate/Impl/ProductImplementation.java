package com.niit.newpgpniithibernate.Impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.newpgpniithibernate.DbConfig;
import com.niit.newpgpniithibernate.DAO.ProductDAO;
import com.niit.newpgpniithibernate.Model.ProductModel;

public class ProductImplementation implements ProductDAO
{
	private Transaction trans;
	private Session sess;
	private boolean b=true;
	 public boolean insertProduct(ProductModel p)
	 {
		try
		{
			DbConfig db=new DbConfig();
			sess=db.getSession();
			trans=sess.beginTransaction();
			sess.save (p);
			trans.commit();
		}
		catch(Exception r)
		{
		System.out.println(r);	
		}
		return b;
	 }
	}
