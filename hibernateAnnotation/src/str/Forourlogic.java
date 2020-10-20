package str;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Forourlogic {
	
	public static void main(String[] args) {
		
		try
		{
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build(); 
			Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
				
			SessionFactory factory=meta.getSessionFactoryBuilder().build();
			Session session=factory.openSession();
			
			Transaction t=session.beginTransaction();
			customers c1=new customers();
			c1.setCustomerid(100);
			c1.setCustomername("sharmi");
			session.save(c1);
			t.commit();
			System.out.println("Inserted...");
			
		}
		catch(Exception ex)
		{
			
		}
		
	}

}
