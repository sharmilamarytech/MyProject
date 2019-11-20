package com.niit.newpgpniithibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConfig 
{
	public Session getSession()
	{
		System.out.println("SessionIn");
		Configuration cfg=new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session sess=sf.openSession();
		System.out.println("SessionOut");
		return sess;
	}

}
