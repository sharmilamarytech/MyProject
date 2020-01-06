package com.niit.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Ecommerce_Bd_ILT.DAO.CategoryDAO;
import com.niit.Ecommerce_Bd_ILT.DAO.ProductDAO;
import com.niit.Ecommerce_Bd_ILT.DAO.UserDAO;
import com.niit.Ecommerce_Bd_ILT.Model.CategoryModel;
import com.niit.Ecommerce_Bd_ILT.Model.ProductModel;
import com.niit.Ecommerce_Bd_ILT.Model.UserModel;

@Controller
public class HomeController
{
	@Autowired
	ProductDAO product1;
	
	@Autowired
	private UserDAO user1;
	
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
   
   @RequestMapping(value="/registerpage")
   public ModelAndView addUser(HttpServletRequest request)throws NoSuchAlgorithmException
   {
	   int u_id=Integer.valueOf(request.getParameter("userid"));
	   
	   String u_name=request.getParameter("username");
	   String u_pass=request.getParameter("userpass");
	   String u_addr=request.getParameter("useraddress");
	   String u_mail=request.getParameter("usermail");
	   
	   int u_age=Integer.valueOf(request.getParameter("userage"));
	   String u_city=request.getParameter("usercity");
	   String u_phone=request.getParameter("userphone");
	   String u_gen=request.getParameter("usergen");
	   
	   UserModel u=new UserModel();
	   u.setUserid(u_id);
	   u.setName(u_name);
	   u.setPassword(u_pass);
 	   u.setAddress(u_addr);
 	   u.setEmail(u_mail);
 	   u.setAge(u_age);
 	   u.setCity(u_city);
 	   u.setPhone(u_phone);
 	   u.setGender(u_gen);
 	   u.setRole("ROLE_USER");
 	   user1.addUser(u);
 		
 		
 		ModelAndView mv = new ModelAndView("index");
 		return mv;
	   
   }
   
   @RequestMapping("/categoryproductlist")
   public ModelAndView productListFilter(HttpServletRequest request)
   {
	   List<ProductModel> clist=product1.getFilterProducts(Integer.valueOf(request.getParameter("id")));
	   ModelAndView mv =new ModelAndView("categoryproductlist");
	   mv.addObject("list",clist);
	   return mv;
   }
   @RequestMapping("/userlogged")
   public ModelAndView notacess()
   {
	   ModelAndView m9=new ModelAndView("noAccessPage");
       return m9;
	   
   }
   
}