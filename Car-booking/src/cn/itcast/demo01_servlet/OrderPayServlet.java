package cn.itcast.demo01_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.OrderService;
import cn.itcast.demo03_serviceImpl.OrderServiceImpl;

/**
 *  OrderPayServlet
 */
public class OrderPayServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取订单id
		String oid=request.getParameter("oid");
		//修改订单状态
		OrderService os=new OrderServiceImpl();
		os.updateOrderStatus(oid,2);
		//转发到所有订单的servlet
		request.getRequestDispatcher("/FindAllOrdersByUserServlet").forward(request,response); 
		
		return ;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
