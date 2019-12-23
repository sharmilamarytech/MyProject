package com.niit.Ecommerce_Bd_ILT.Impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Ecommerce_Bd_ILT.DAO.UserDAO;
import com.niit.Ecommerce_Bd_ILT.Model.UserModel;

@Repository
public class UserDAOImpl  implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory=sf;
	}
	public void addUser(UserModel u) 
	{
    Session s=sessionFactory.openSession();
		s.beginTransaction();
	    s.save(u);
		s.getTransaction().commit();
		s.close();
	
		
	}

	public void getId(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(UserModel u) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<UserModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
