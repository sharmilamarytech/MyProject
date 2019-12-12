package com.niit.controller;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Ecommerce_Bd_ILT.DAO.CategoryDAO;
import com.niit.Ecommerce_Bd_ILT.DAO.ProductDAO;
import com.niit.Ecommerce_Bd_ILT.Model.CategoryModel;
import com.niit.Ecommerce_Bd_ILT.Model.ProductModel;
@Controller
public class CategoryController 
{
	@Autowired
	ProductDAO product1;
	
	@Autowired
	CategoryDAO category1;
	
	
	@RequestMapping(value="/product")
	public ModelAndView addproduct()
	{
		List<CategoryModel> list=category1.getAll();
		ModelAndView m3=new ModelAndView("Adding");
		m3.addObject("clist", list);
		return m3;
	}
	
	@RequestMapping(value="/category")
	public ModelAndView addcategory()
	{
		List<CategoryModel> list=category1.getAll();
		ModelAndView m4=new ModelAndView("AddingCategory");
		m4.addObject("clist", list);
		return m4;
	}
	@ModelAttribute
	public void addAttributes(Model model)
	{
		model.addAttribute("clist",category1.getAll());
	}
	
	
	@RequestMapping(value="addProductAction")
	public ModelAndView addproductpage(@RequestParam("file") MultipartFile file,HttpServletRequest request)
	{
		try
		{
		int pid=Integer.parseInt(request.getParameter("id"));
		
		String pname=request.getParameter("pname");
		
		int price=Integer.parseInt(request.getParameter("price"));
		
		int cid=Integer.valueOf(request.getParameter("cid"));
		CategoryModel c=category1.findById(cid);
		
		
		ProductModel p=new ProductModel();
		
		p.setCategoryid(c);
		
		p.setProductid(pid);
		
		p.setProductname(pname);
		
		p.setProductprice(price);
		
		String originalfile=file.getOriginalFilename();
		p.setP_image(originalfile);
		String filepath=request.getSession().getServletContext().getRealPath("/");
		byte imagebyte[]=file.getBytes();
		BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/images/"+originalfile));
		 fos.write(imagebyte);
		fos.close();
		
		//ProductDAOImpl pm=new ProductDAOImpl();
		
		product1.addproduct(p);
		}
		
		catch(Exception t)
		{
			System.out.println(t);
			t.printStackTrace();
		}
		ModelAndView m1=new ModelAndView("sucess");
		return m1;
		
	}
	
	@RequestMapping(value="/addCategoryAction")
	public ModelAndView addCategoryPage(HttpServletRequest request)
	{
		try
		{
			System.out.println("IN");
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		
		CategoryModel c=new CategoryModel();
		
		c.setCategoryid(cid);
		
		c.setCategoryname(cname);
		
		category1.addCategory(c);
		System.out.println("out");
		}
		catch(Exception t)
		{
			System.out.println(t);
			t.printStackTrace();
		}
		ModelAndView m6=new ModelAndView("sucess");
		return m6;
	}
	}