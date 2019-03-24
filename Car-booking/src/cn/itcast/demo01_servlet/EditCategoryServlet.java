package cn.itcast.demo01_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.CategoryService;
import cn.itcast.demo03_serviceImpl.CategoryServiceImpl;
import cn.itcast.demo06_domain.Category;

/**
 * EditCategoryServlet
 */
public class EditCategoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService cs=new CategoryServiceImpl();
		String cid=request.getParameter("cid");
		String cname1=request.getParameter("cname1");
		String cname2=request.getParameter("cname2");
		cs.editProductCategory(cname1,cname2);
		Category c=new Category();
		c.setCid(Integer.parseInt(cid));
		c.setCname(cname2);
		boolean b=cs.editCategory(c);
		if(b){
			request.setAttribute("message","分类修改成功!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message","分类修改失败!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
