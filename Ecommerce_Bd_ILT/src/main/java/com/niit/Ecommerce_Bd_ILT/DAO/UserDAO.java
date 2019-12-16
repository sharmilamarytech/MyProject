package com.niit.Ecommerce_Bd_ILT.DAO;

import java.util.ArrayList;

import com.niit.Ecommerce_Bd_ILT.Model.UserModel;

public interface UserDAO 
{
	//create
	public void addUser(UserModel u);
	//read
	public void getId(int id);
	//update
	public void update(UserModel u);
	//deleted
	public void deleteById(int id);
	//get all
	public ArrayList<UserModel> getAll();
	}
