package cn.itcast.demo01_servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.UserService;
import cn.itcast.demo03_serviceImpl.UserServiceImpl;
import cn.itcast.demo06_domain.User;
import cn.itcast.demo07_utils.MyBeanUtils;

/**
 * 注册的servlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String[]>map=request.getParameterMap();
		
		
		/*你是以表单提交，那么request.getParameterMap()中将包含你表单里面所有input标签的数据，以其name为key，以其value为值，
		 * 它是以Map<String,String[]>存在，即：key是String型，value是String型数组。
		 */
		//使用工具类完成数据的封装
		User u= new User();
		MyBeanUtils.populate(u, map);
		
		UserService us =new UserServiceImpl();
		us.regist(u);
		
		request.setAttribute("msg", "注册成功!");
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
