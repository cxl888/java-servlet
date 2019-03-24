package cn.itcast.demo01_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.demo02_service.OrderService;
import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.OrderServiceImpl;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;
import cn.itcast.demo06_domain.OrderItem;
import cn.itcast.demo06_domain.Product;

/**
 * Servlet implementation class DetailOrdersForUser
 */
public class DetailOrdersForUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oid=request.getParameter("oid");
		String totalmoney=request.getParameter("totalmoney");
		String ordertime=request.getParameter("ordertime");
		int orderstatus=Integer.parseInt(request.getParameter("orderstatus"));
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
	
		OrderService os=new OrderServiceImpl();
		OrderItem oi=os.findOrderItemByOid(oid);
		int pnum=oi.getPnum();
		ProductService ps=new ProductServiceImpl();
		String pid=String.valueOf(oi.getPid());
		Product p=ps.findProductByPid(pid);
		//System.out.println(pnum);
		System.out.println(p.getImageurl());
		
		request.setAttribute("oid", oid);
		request.setAttribute("totalmoney",totalmoney);
		request.setAttribute("ordertime",ordertime);
		request.setAttribute("orderstatus",orderstatus);
		request.setAttribute("name",name);
		request.setAttribute("phone",phone);
		request.setAttribute("address",address);
		request.setAttribute("product",p);
		
		 //使用request对象的getSession()获取session，如果session不存在则创建一个
		HttpSession session = request.getSession();
		        //将数据存储到session中
		session.setAttribute("pnum", pnum);
		session.setAttribute("pname",p.getPname());
		//session.setAttribute("product", p);
		session.setAttribute("imageurl",p.getImageurl());
		session.setAttribute("oil",p.getOil());
		session.setAttribute("rank",p.getRank());
		session.setAttribute("displacement",p.getDisplacement());
		session.setAttribute("category",p.getCategory());
		request.getRequestDispatcher("/jsp/order_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
