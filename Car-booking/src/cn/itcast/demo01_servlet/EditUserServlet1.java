package cn.itcast.demo01_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.UserService;
import cn.itcast.demo03_serviceImpl.UserServiceImpl;
import cn.itcast.demo06_domain.User;

/**
 * Servlet implementation class EditUserServlet1
 */
public class EditUserServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		u.setUid(Integer.parseInt(request.getParameter("uid")));
		
		u.setPassword(request.getParameter("password"));
		u.setRealname(request.getParameter("realname"));
		u.setEmail(request.getParameter("email"));
		u.setBirthday(request.getParameter("birthday"));
		UserService us=new UserServiceImpl();
		boolean status=us.editUser(u);
		if(status){
			request.setAttribute("message","用户修改成功!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message","用户修改失败!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
	}

}
