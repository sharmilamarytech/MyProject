package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController
{
	@RequestMapping(value="/product")
	public ModelAndView addproduct()
	{
		ModelAndView m3=new ModelAndView("Adding");
		return m3;
	}
	@RequestMapping(value="/category")
	public ModelAndView addcategory()
	{
		ModelAndView m4=new ModelAndView("AddingCategory");
		return m4;
	}
}
