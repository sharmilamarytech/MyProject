package com.niit.Ecommerce_Bd_ILT.DAO;

import java.util.List;

import com.niit.Ecommerce_Bd_ILT.Model.CartModel;

public interface CartDAO 
{
	public void save(CartModel cart);
	   //read
			public CartModel getId(int id);
			//update
			public void update(CartModel cart);
			//deleted
			public void delete(CartModel p);
			//Get All
			public List<CartModel> getAll();
			
			public CartModel findById(int id);
			
			public List<CartModel> check(int productid);

}
