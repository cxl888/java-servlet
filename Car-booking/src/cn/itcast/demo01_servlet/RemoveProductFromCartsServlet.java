package cn.itcast.demo01_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo06_domain.Cart;

/**
 * RemoveProductFromCartsServlet
 */
public class RemoveProductFromCartsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid =request.getParameter("pid");
		Object obj=request.getSession().getAttribute("cart");
		if(obj==null){
			request.setAttribute("msg", "购物车已超时,请重新操作!");
			request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
			return ;
		}
		Cart c =(Cart)obj;
		c.removeProductByid(pid);
		request.getSession().setAttribute("cart", c);
		request.getRequestDispatcher("/jsp/cart.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
