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
 * Dynamic_category_2
 */
public class Dynamic_category_2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		String pname=request.getParameter("pname");
		String market_price=request.getParameter("market_price");
		String shop_price=request.getParameter("shop_price");
		String oil=request.getParameter("oil");
		String rank=request.getParameter("rank");
		String displacement=request.getParameter("displacement");
		String pdesc=request.getParameter("pdesc");
		CategoryService cs=new CategoryServiceImpl();
		List<Category> list=cs.findAllCategory();
		request.setAttribute("pid", pid);
		request.setAttribute("pname", pname);
		request.setAttribute("market_price",market_price);
		request.setAttribute("shop_price",shop_price);
		request.setAttribute("oil",oil);
		request.setAttribute("rank",rank);
		request.setAttribute("displacement",displacement);
		request.setAttribute("pdesc",pdesc);
		request.setAttribute("cname_list",list);
		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
