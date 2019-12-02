package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Ecommerce_Bd_ILT.DAO.CategoryDAO;
import com.niit.Ecommerce_Bd_ILT.DAO.ProductDAO;
import com.niit.Ecommerce_Bd_ILT.Model.CategoryModel;

@Controller
public class HomeController
{
	@Autowired
	ProductDAO product1;
	
	@Autowired
	CategoryDAO category1;
	
   @RequestMapping("/")	
   public ModelAndView index()
   {
	   List<CategoryModel> list=category1.getAll();
	   ModelAndView m1=new ModelAndView("index");
	   m1.addObject("clist",list);
	   return m1;
   }
   @RequestMapping("/login")
   public ModelAndView loginpage()
   {
	   ModelAndView m2=new ModelAndView("login");
	   return m2;
   }
   
   @RequestMapping("/register")
   public ModelAndView regpage()
   {
	   ModelAndView m3=new ModelAndView("registerpage");
	   return m3;
   }
}