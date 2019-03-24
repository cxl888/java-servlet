package cn.itcast.demo01_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.CategoryService;
import cn.itcast.demo03_serviceImpl.CategoryServiceImpl;
import cn.itcast.demo06_domain.Category;


/**
 * FindAllCategoryServlet
 */
public class FindAllCategoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService cs=new CategoryServiceImpl();
		List<Category> list=cs.findAllCategory();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/category/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
