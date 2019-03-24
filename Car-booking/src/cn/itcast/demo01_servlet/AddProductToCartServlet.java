package cn.itcast.demo01_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;
import cn.itcast.demo06_domain.Cart;
import cn.itcast.demo06_domain.Product;


public class AddProductToCartServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		String count=request.getParameter("count");
		ProductService ps=new ProductServiceImpl();
		Product p=ps.findProductByPid(pid);
		Object obj =request.getSession().getAttribute("cart");
		Cart c=null;
		if(obj==null){
			c=new Cart();
		}else{
			c=(Cart)obj;
		}
		c.addProductToCart(p, Integer.parseInt(count));
		request.getSession().setAttribute("cart", c);
		request.getRequestDispatcher("/jsp/cart.jsp").forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
