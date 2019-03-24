package cn.itcast.demo01_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.OrderService;
import cn.itcast.demo03_serviceImpl.OrderServiceImpl;

/**
 * class DelOrderByOid
 */
public class DelOrderByOid extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oid=request.getParameter("oid");
		OrderService os=new OrderServiceImpl();
		os.delOrderAndOrderItem(oid);
		request.getRequestDispatcher("/FindAllOrdersByUserServlet").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
