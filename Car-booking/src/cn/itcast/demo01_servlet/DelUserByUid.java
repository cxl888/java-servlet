package cn.itcast.demo01_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.OS;

import cn.itcast.demo02_service.OrderService;
import cn.itcast.demo02_service.UserService;
import cn.itcast.demo03_serviceImpl.OrderServiceImpl;
import cn.itcast.demo03_serviceImpl.UserServiceImpl;
import cn.itcast.demo06_domain.Orders;

/**
 * Servlet implementation class DelUserByUid
 */
public class DelUserByUid extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		UserService us=new UserServiceImpl();
		//订单的级联删除
		OrderService os=new OrderServiceImpl();
		List<Orders> oids=os.findAllOidsByUid(uid);
		for(int i=0;i<oids.size();i++){
              if(oids.get(i).equals(null))
              {
            	  System.out.println("Yes");
              }
		      os.delOrderAndOrderItem(oids.get(i).getOid());

		   }
		
		boolean b=us.delUserByUid(uid);
		if(b){
			request.setAttribute("message","用户删除成功!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message","用户删除失败!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
