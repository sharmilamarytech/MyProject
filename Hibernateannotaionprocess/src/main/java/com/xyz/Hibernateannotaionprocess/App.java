package com.xyz.Hibernateannotaionprocess;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata data=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory=data.getSessionFactoryBuilder().build();
		
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		Employee e2=new Employee();
		e2.setId(101);
		e2.setFirstname("sharmila");
		e2.setLastname("mary");
		
		
		session.save(e2);
		
		t.commit();
		
		System.out.println("Saved");
		factory.close();
		session.close();
    }
}
