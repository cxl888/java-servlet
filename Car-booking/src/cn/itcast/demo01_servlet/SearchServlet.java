package cn.itcast.demo01_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;
import cn.itcast.demo06_domain.Product;

/**
 * SearchServlet
 */
public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String search =request.getParameter("search");
		//避免空指针
		if(search==null){
			search="";
		}
		if(search.equals("")){
			request.getRequestDispatcher("/FindProductByCategoryName").forward(request, response); 
			return ;
		}else{
		
		ProductService ps=new ProductServiceImpl();
		List<Product> searchlist=ps.searchProduct(search);
		    if(searchlist==null){
			     request.setAttribute("msg", "对不起,商城没该商品!换个吧!");
			     request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		    	
		    }else{
		    request.setAttribute("searchlist",searchlist);
		
		    request.getRequestDispatcher("/jsp/product_search.jsp").forward(request, response);
		    }
		}
		
	}

}
