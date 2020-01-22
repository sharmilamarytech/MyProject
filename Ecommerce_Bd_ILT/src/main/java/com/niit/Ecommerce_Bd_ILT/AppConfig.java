package com.niit.Ecommerce_Bd_ILT;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Ecommerce_Bd_ILT.Model.CartModel;
import com.niit.Ecommerce_Bd_ILT.Model.CategoryModel;
import com.niit.Ecommerce_Bd_ILT.Model.ProductModel;

import com.niit.Ecommerce_Bd_ILT.Model.UserModel;



@Configuration
@ComponentScan({"com.niit.Ecommerce_Bd_ILT"})
@EnableTransactionManagement
public class AppConfig 
{
 @Autowired
 @Bean(name="datasource")

    public DataSource datasource()
    {
	 DriverManagerDataSource ds =new DriverManagerDataSource();
	 ds.setDriverClassName("org.h2.Driver");
	 ds.setUrl("jdbc:h2:tcp://localhost/~/project3");
	 ds.setUsername("sa");
	 ds.setPassword("");
	return ds;
	 
 }
  private Properties getHibernateProperties()
  {
	  Properties prop =new Properties();
	  prop.put("hibernate.show_sql", "true");
	  prop.put("hibernate_dialect", "org.hibernate.dialect.h2Dialect");
	  prop.put("hibernate_format_sql", "true");
	  prop.put("hibernate.hbm2ddl.auto", "update");
	  return prop;
	  
  }
  @Autowired
  @Bean
  public SessionFactory sessionFactory(DataSource dataSource)
  {
	  LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
	  builder.addProperties(getHibernateProperties());
	 
	  builder.addAnnotatedClass(ProductModel.class);
	  builder.addAnnotatedClass(CategoryModel.class);
	  builder.addAnnotatedClass(UserModel.class);
	  builder.addAnnotatedClass(CartModel.class);
      
	  return  builder.buildSessionFactory();
	  
  }  
	  
//Create a transaction manager
			@Bean
			@Autowired 
			public HibernateTransactionManager txManager(SessionFactory sessionFactory) 
			   {
		                return new HibernateTransactionManager(sessionFactory);
		        }
			
	  

}
