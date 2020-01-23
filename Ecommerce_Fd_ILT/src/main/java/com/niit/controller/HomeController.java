package com.niit.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Ecommerce_Bd_ILT.DAO.CartDAO;
import com.niit.Ecommerce_Bd_ILT.DAO.CategoryDAO;
import com.niit.Ecommerce_Bd_ILT.DAO.ProductDAO;
import com.niit.Ecommerce_Bd_ILT.DAO.ShipDAO;
import com.niit.Ecommerce_Bd_ILT.DAO.UserDAO;
import com.niit.Ecommerce_Bd_ILT.Model.CartModel;
import com.niit.Ecommerce_Bd_ILT.Model.CategoryModel;
import com.niit.Ecommerce_Bd_ILT.Model.ProductModel;
import com.niit.Ecommerce_Bd_ILT.Model.ShipModel;
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
	
	@Autowired
	CartDAO cart1;
	
	@Autowired
	ShipDAO ship1;
	
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
	public String userLogged() { 
		return "redirect:/";	
	}
   @RequestMapping("/noAccessPage")
   public ModelAndView notacess()
   {
	   ModelAndView m9=new ModelAndView("noAccessPage");
       return m9;
	   
   }
   
   @RequestMapping("/user/product")
	public ModelAndView product(HttpServletRequest request) 
	{
		
	    int id=Integer.valueOf(request.getParameter("id"));
	    ProductModel p=product1.findById(id);
		ModelAndView mv = new ModelAndView("productdetails");
		List<CategoryModel> c=category1.getAll();
		mv.addObject("list",c);
		mv.addObject("product", p);
		return mv;
	}
   
   
 //AddCartTable data
	@RequestMapping(value="/user/productdetails", method=RequestMethod.POST)
	public ModelAndView addCarttable(HttpServletRequest request) 
	{
		
		int id=Integer.valueOf(request.getParameter("prodid"));
		
		int quan=Integer.valueOf(request.getParameter("prodquantity"));
		
		int price=Integer.valueOf(request.getParameter("prodprice"));
		
		System.out.println(""+id+""+quan+""+price);
		ProductModel p=product1.findById(id);
		CartModel g=new CartModel();
		g.setPrices(price);
		g.setQuantity(quan);
		g.setProductid(p);
		
		List<CartModel> list=cart1.check(id);
		//cart1.save(g);
		int count=list.size();
		System.out.println("No of times: "+count);
		if(count==0)
		{
			cart1.save(g);
		}
		else
		{
			CartModel cart=cart1.findById(list.get(0).getCartid());
			int e=cart.getQuantity();
			
			int tot=e+quan;
			cart.setQuantity(tot);
			cart1.update(cart);
		}
		
		ModelAndView mv = new ModelAndView("viewcartdetail");
		
		List<CartModel> cartList=cart1.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
		
	}
	@RequestMapping("/user/cart_delete")
	public ModelAndView editCart(HttpServletRequest request)
	{
		int cid=Integer.valueOf(request.getParameter("id"));
		CartModel c=cart1.findById(cid);
		cart1.delete(c);
		
		ModelAndView mv=new ModelAndView("viewcartdetail");
		List<CartModel> cartList=cart1.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
	}
	
	//code for shipdetails
		@RequestMapping(value="/user/customerdetails")
		
		public ModelAndView customer()
		{
			ModelAndView m18=new ModelAndView("customerdetails");
		    return m18;
		}
		@RequestMapping(value="/user/customer")
		public ModelAndView customerpage(HttpServletRequest request)
		{
		    
			System.out.println("OUT");
		
		     //	int c_id=Integer.valueOf(request.getParameter("cusid"));
		        
			int c_id = Integer.parseInt(request.getParameter("cusid"));
		        
		        String c_name=request.getParameter("cname");
		 	   
		 	   String c_email=request.getParameter("cemail");
		 	   
		 	   String c_addr=request.getParameter("caddress");
		 	   
		 	   String c_phone=request.getParameter("cphone");
		 	   
		 	  String c_pay=request.getParameter("cpay");
		 	  
		 	  
		 	  ShipModel s1=new ShipModel();
		 	  
		 	  s1.setCusid(c_id);
		 	  s1.setCusname(c_name);
		 	  s1.setEmail(c_email);
		 	  s1.setAddress(c_addr);
		 	  s1.setPhone(c_phone);
		 	  s1.setPay(c_pay);
	          	
		 	  ship1.addCus(s1);
		 	  System.out.println("><><><><>"+s1.getCusname());
		 	 ModelAndView m18=new ModelAndView("customerdetails");
			    return m18;
			  
		}
		//testing
 		
	 	@RequestMapping(value="/admin/viewshipdetails")
	 		
	 		public ModelAndView views()
	 		{
	 		System.out.println("IN");
	 		List<ShipModel> list=ship1.getAll();
	 		
	 			ModelAndView m18=new ModelAndView("viewshipdetails");
	 			m18.addObject("list",list);
	 		    return m18;
	 		}

		@RequestMapping("/user/thankyoupage")
		public ModelAndView thankyou(HttpServletRequest request)
		{
			
			System.out.println("****");
			
			ModelAndView k=new ModelAndView("thankyoupage");
			
			return k;
			
			
		}
		@RequestMapping("/user/check")
		public ModelAndView check(HttpServletRequest request)
		{
			System.out.println("hai");
			int id=Integer.parseInt(request.getParameter("cusid"));
			//String cemail=request.getParameter("cemail");
			 List<ShipModel> list=ship1.getAll();
			ModelAndView ck=new ModelAndView("thankyoupage");
			ck.addObject("sdetail",ship1.findById(id) );	
			// ck.addObject("slist", list);
			return ck;
		}
	   
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
