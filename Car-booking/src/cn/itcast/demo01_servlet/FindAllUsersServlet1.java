package cn.itcast.demo01_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.UserService;
import cn.itcast.demo03_serviceImpl.UserServiceImpl;
import cn.itcast.demo06_domain.User;
import cn.itcast.demo07_utils.PageBean;

/**
 * Servlet implementation class FindAllUsersServlet1
 */
public class FindAllUsersServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String curr= request.getParameter("pageNumber");
		//避免空指针异常
		if(curr==null||"".equals(curr)){
			curr="1";
		}
		int cu=Integer.parseInt(curr);
		PageBean pb=new PageBean();
		//要查询的当前页
		pb.setPageNumber(cu);
		//每页的条数
		pb.setPageSize(12);
		UserService us=new UserServiceImpl();
		int count=us.findUserTotalCount();
		pb.setTotalRecord(count);
		List<User> list=us.findAllUser(pb.getStartIndex(),pb.getPageSize());
		pb.setResult(list);
		//store
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/admin/user/list.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
