package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Ecommerce_Bd_ILT.DAO.ProductDAO;
import com.niit.Ecommerce_Bd_ILT.Model.ProductModel;

@Controller
public class ProductList 
{
	@Autowired
	ProductDAO products;
	
	@RequestMapping (value="/productlistview")
	public ModelAndView getlist()
	{
		ModelAndView mv=new ModelAndView("productlistview");
		List<ProductModel>slist=products.getAll();
		mv.addObject("slist",slist);
		return mv;
		
	}

}
