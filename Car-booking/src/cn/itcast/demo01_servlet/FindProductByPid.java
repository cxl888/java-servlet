package cn.itcast.demo01_servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo02_service.UserService;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;
import cn.itcast.demo03_serviceImpl.UserServiceImpl;
import cn.itcast.demo06_domain.Product;
import cn.itcast.demo06_domain.User;
import cn.itcast.demo07_utils.HistoryUtils;
import cn.itcast.demo07_utils.LoginUtils;


public class FindProductByPid extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		//浏览记录
		String history=null;
		Cookie cookies=null;
		
		ProductService ps= new ProductServiceImpl();
		Product p=ps.findProductByPid(pid);
		request.setAttribute("p", p);
		
		//浏览记录
		LinkedList<String> linkedList =HistoryUtils.findHistories(request, p.getImageurl());
		if(linkedList==null){
		System.out.println("null");
		 
		}else{
			for(int i=0;i<linkedList.size();i++)
			  {
			   System.out.println(linkedList.get(i));
			  }
		}
		
		request.getSession().setAttribute("linkedList",linkedList);
		Cookie c[]=request.getCookies();
	    if(c!=null){
	          for(int i=0;i<c.length;i++)
	          {
	        	  if(c[i].getName().equals("history")){
	        		  history=c[i].getValue();
	        	  }
	          }
	          
	     }
	    boolean b=LoginUtils.isLogin(request);
	    if(history==null){
	    	 cookies =new Cookie("history",p.getImageurl());
			 cookies.setMaxAge(900);
			 if(b){
				 UserService us = new UserServiceImpl();
				 User u=(User)request.getSession().getAttribute("user");
				 us.addHistoriesByUsername(u.getUsername(),p.getImageurl());
			 }
	     }
	    else{
	    	 cookies =new Cookie("history",history+"-"+p.getImageurl());
	    	 cookies.setMaxAge(900);
             if(b){
            	 UserService us = new UserServiceImpl();
            	 User u=(User)request.getSession().getAttribute("user");
            	 us.addHistoriesByUsername(u.getUsername(),history+"-"+p.getImageurl());
			 }
	     }
	    response.addCookie(cookies);
		request.getRequestDispatcher("/jsp/product_info.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
