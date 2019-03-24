package cn.itcast.demo01_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.OrderService;
import cn.itcast.demo03_serviceImpl.OrderServiceImpl;
import cn.itcast.demo06_domain.Orders;
import cn.itcast.demo06_domain.User;
import cn.itcast.demo07_utils.LoginUtils;
import cn.itcast.demo07_utils.PageBean;

/**
 * FindAllOrdersByUserServlet
 */
public class FindAllOrdersByUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前登录用户
		boolean b=LoginUtils.isLogin(request);
		if(b){
			String curr=request.getParameter("pageNumber");
			//需要避免空指针异常的发生
			if(curr==null || "".equals(curr)){
				curr="1";
			}
		    int cu=Integer.parseInt(curr);
		    PageBean pb=new PageBean();
		    
		    
		    pb.setPageNumber(cu);
		    //设置每页显示的条数
		    pb.setPageSize(5);
			User u=(User)request.getSession().getAttribute("user");
			//根据身份查询
			OrderService os=new OrderServiceImpl();
			int count=os.findTotalCountByOrders(u);
		    //设置符合条件的总条数
		    pb.setTotalRecord(count);
		    List<Orders> list=os.findAllOrdersByUserServlet(pb.getStartIndex(),pb.getPageSize(),u);
			//List<Orders> list=os.findAllOrdersByUserServlet(u);
			//存request
			request.setAttribute("olist",list);
			//设置符合条件的集合
			pb.setResult(list);
		    //将PageBean对象存放到request域中，以便于在jsp页面获取数据
		    request.setAttribute("pb", pb);
		    
			request.getRequestDispatcher("/jsp/order_list.jsp").forward(request, response);
			}else{
			request.setAttribute("msg","无法查到订单,请先登录!");
			request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
