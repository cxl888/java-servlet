package cn.itcast.demo01_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String realname=request.getParameter("realname");
		String email=request.getParameter("email");
		String birthday=request.getParameter("birthday");
		
		request.setAttribute("uid", uid);
		request.setAttribute("realname", realname);
		request.setAttribute("username",username);
		request.setAttribute("password",password);
		request.setAttribute("email",email);
		request.setAttribute("birthday",birthday);
		
		request.getRequestDispatcher("/admin/user/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
