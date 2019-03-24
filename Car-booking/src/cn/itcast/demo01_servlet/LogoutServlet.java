package cn.itcast.demo01_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取用户session对象并销毁session对象中的user对象 
		  request.getSession().removeAttribute("user"); 
		//2、转发到登录界面，重新登录 
		  request.getRequestDispatcher("/jsp/login.jsp").forward(request, response); 

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
