package cn.itcast.demo01_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.demo02_service.UserService;
import cn.itcast.demo03_serviceImpl.UserServiceImpl;
import cn.itcast.demo06_domain.User;


public class LoginServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String username = request.getParameter("username"); 
		  String password = request.getParameter("password");
		  HttpSession session = request.getSession();
		  String checkcode= request.getParameter("code");//验证码
		  String ckcd= (String)session.getAttribute("checkCode");//验证码
		  //System.out.println(ckcd);
		  //System.out.println(checkcode);
		  String r2=request.getParameter("r2");
		  
		  UserService us = new UserServiceImpl(); 
		  User u =us.findUserByUsername(username);
		  
		  if(u==null)
		  { 
			   request.setAttribute("msg","用户名不存在，请先去注册!"); 
			   request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response); 
			   return; 
		  }
		  else if(u.getUsername().equals("admin")){
			  String dbPassword = u.getPassword(); 
			  if(dbPassword.equals(password)){
				  request.getRequestDispatcher("/admin/home.jsp").forward(request, response); 
			  }
		  }
		  else
		  { 
			   String dbPassword = u.getPassword(); 
			   if(dbPassword.equals(password))
			   {  
				   if(checkcode.equals(ckcd)){
				   Cookie cookies =new Cookie("u",username+"-"+password);
				   cookies.setMaxAge(900);
				   //记住用户名
				   if(r2!=null)
				   {  
					   response.addCookie(cookies);
				   }
				
			      request.getSession().setAttribute("user",u); 
			      //暂时跳转到静态的jsp页面，待完成商品列表后，需修改为转发到servlet 
			      request.getRequestDispatcher("/FindProductByCategoryName").forward(request, response); 
			      return;
				  }
				  else{ 
					request.setAttribute("msg","验证码错误!"); 
					request.getRequestDispatcher("/jsp/login.jsp").forward(request, response); 
				  } 
			   }
			   else{ 
			    request.setAttribute("msg","密码错误，请重试!"); 
			    request.getRequestDispatcher("/jsp/login.jsp").forward(request, response); 
			   } 
		  }


	}

}
