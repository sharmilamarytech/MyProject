package com.niit.Ecommerce_Bd_ILT.DAO;

import java.util.List;

import com.niit.Ecommerce_Bd_ILT.Model.CategoryModel;

public interface CategoryDAO
{
 public boolean addCategory(CategoryModel category1);
 
 
 public List<CategoryModel>getAll();
 
 public CategoryModel findById(int id);
}
