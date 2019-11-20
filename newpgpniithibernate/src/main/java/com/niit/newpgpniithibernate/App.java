package com.niit.newpgpniithibernate;

import com.niit.newpgpniithibernate.Impl.CategoryImplementation;
import com.niit.newpgpniithibernate.Impl.ProductImplementation;
import com.niit.newpgpniithibernate.Model.CategoryModel;
import com.niit.newpgpniithibernate.Model.ProductModel;

public class App 
{
	public static void main(String[] arg)
	{
		ProductModel p=new ProductModel();
		p.setPid(101);
		p.setPname("apple");
		p.setPcost(100);
	    ProductImplementation pm=new ProductImplementation();
	    pm.insertProduct(p);
	       
//	     CategoryModel c=new CategoryModel();
//	     c.setCid(201);
//	     c.setCname("fruits");
//    	 CategoryImplementation cm=new CategoryImplementation();
//    	 cm.insertCategory(c);

   	 
		 
		 System.out.println("inserted");
	}

}
