package cn.itcast.demo01_servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.CategoryService;
import cn.itcast.demo03_serviceImpl.CategoryServiceImpl;

/**
 * AddCategoryServlet
 */
public class AddCategoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService cs=new CategoryServiceImpl();
		String cname=request.getParameter("cname");
		boolean b=cs.addCategory(cname);
		if(b){
			request.setAttribute("message","分类添加成功!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message","分类添加失败!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
	}

}
