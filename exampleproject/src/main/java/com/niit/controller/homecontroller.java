package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class homecontroller 
{
@RequestMapping("/htmlpage")
public ModelAndView index()
{
	ModelAndView m1=new ModelAndView("htmlpage");
	return  m1;
}

}
