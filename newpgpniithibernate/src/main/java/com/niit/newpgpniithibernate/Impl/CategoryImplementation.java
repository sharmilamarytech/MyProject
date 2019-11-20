package com.niit.newpgpniithibernate.Impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.newpgpniithibernate.DbConfig;
import com.niit.newpgpniithibernate.DAO.CategoryDAO;
import com.niit.newpgpniithibernate.Model.CategoryModel;

public class CategoryImplementation implements CategoryDAO
{
private Transaction trans;
private Session sess;
private boolean b=true;
public boolean insertCategory(CategoryModel c) 
{
	try
	{
		DbConfig db=new DbConfig();
		sess=db.getSession();
		trans=sess.beginTransaction();
		sess.save(c);
		trans.commit();
		
	}
	catch(Exception r)
	{
		System.out.println(r);
	}
	return b;
}
}
