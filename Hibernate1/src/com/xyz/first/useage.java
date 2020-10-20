package com.xyz.first;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class useage {
	
	public static void main(String[]args)
	{
		Employee e1=new Employee();
		e1.setEno(1);
		e1.setEname("sharmi");
		e1.setSal(20000.00f);
		e1.setDesign("s/w eng");
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		ses.save(e1);
		tx.commit();
		System.out.println("inserted...");
		
	}

}
