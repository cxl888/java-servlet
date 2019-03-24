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
 * Dynamic_category
 */
public class Dynamic_category extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService cs=new CategoryServiceImpl();
		List<Category> list=cs.findAllCategory();
		/*if(list==null){
			System.out.println("null");
			 
			}else{
				for(int i=0;i<list.size();i++)
				  {
				   System.out.println(list.get(i));
				  }
			}*/
		request.setAttribute("cname_list",list);
		request.getRequestDispatcher("/admin/product/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
